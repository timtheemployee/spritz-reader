package com.wxxtfxrmx.spritzreader

import com.itextpdf.kernel.geom.Vector
import com.itextpdf.kernel.pdf.canvas.parser.EventType
import com.itextpdf.kernel.pdf.canvas.parser.data.IEventData
import com.itextpdf.kernel.pdf.canvas.parser.data.TextRenderInfo
import com.itextpdf.kernel.pdf.canvas.parser.listener.ITextExtractionStrategy
import java.util.*

class SpritzTextExtractionStrategy : ITextExtractionStrategy {

    private var lastStart: Vector? = null
    private var lastEnd: Vector? = null

    /** used to store the resulting String.  */
    private val result = StringBuilder()

    override fun eventOccurred(
        data: IEventData,
        type: EventType
    ) {
        if (type == EventType.RENDER_TEXT) {
            val renderInfo = data as TextRenderInfo
            val firstRender = result.isEmpty()
            val segment = renderInfo.baseline
            val start = segment.startPoint
            val end = segment.endPoint
            if (!firstRender) {
                val x1 = lastStart
                val x2 = lastEnd

                // see http://mathworld.wolfram.com/Point-LineDistance2-Dimensional.html
                val dist =
                    x2!!.subtract(x1).cross(x1!!.subtract(start)).lengthSquared() / x2.subtract(x1)
                        .lengthSquared()

                // we should probably base this on the current font metrics, but 1 pt seems to be sufficient for the time being

                // Note:  Technically, we should check both the start and end positions, in case the angle of the text changed without any displacement
                // but this sort of thing probably doesn't happen much in reality, so we'll leave it alone for now
            }

            if (!firstRender) {
                // we only insert a blank space if the trailing character of the previous string wasn't a space, and the leading character of the current string isn't a space
                if (result[result.length - 1] != ' ' && renderInfo.text.isNotEmpty() && renderInfo.text[0] != ' '
                ) {
                    val spacing = lastEnd!!.subtract(start).length()
                    if (spacing > renderInfo.singleSpaceWidth / 2f) {
                        appendTextChunk(" ")
                        //System.out.println("Inserting implied space before '" + renderInfo.getText() + "'");
                    }
                }
            } else {
                //System.out.println("Displaying first string of content '" + text + "' :: x1 = " + x1);
            }

            //System.out.println("[" + renderInfo.getStartPoint() + "]->[" + renderInfo.getEndPoint() + "] " + renderInfo.getText());
            appendTextChunk(renderInfo.text)
            lastStart = start
            lastEnd = end
        }
    }

    override fun getSupportedEvents(): Set<EventType?>? {
        return Collections.unmodifiableSet(
            LinkedHashSet(
                listOf(EventType.RENDER_TEXT)
            )
        )
    }

    /**
     * Returns the result so far.
     * @return    a String with the resulting text.
     */
    override fun getResultantText(): String? {
        return result.toString()
    }

    /**
     * Used to actually append text to the text results.  Subclasses can use this to insert
     * text that wouldn't normally be included in text parsing (e.g. result of OCR performed against
     * image content)
     * @param text the text to append to the text results accumulated so far
     */
    protected fun appendTextChunk(text: CharSequence?) {
        result.append(text)
    }

}