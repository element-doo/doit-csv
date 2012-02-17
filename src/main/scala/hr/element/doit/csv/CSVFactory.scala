package hr.element.doit.csv

import java.io._
import java.nio.charset.Charset

object CSVFactory {

  def apply(): CSVFactory = {
    new CSVFactory("\"", ";", "\n", Charset.forName("UTF-8"))
  }
}

class CSVFactory private(
    val quotes: String,
    val delimiter: String,
    val newLine: String,
    val encoding: Charset){

  //----------------------------------------------------------------

  def getReader(iS: InputStream) =
    new CSVReader(this, iS)

  def getReaderWithHeaders(iS: InputStream) =
    new CSVReaderWithHeaders(this, iS)

  def getWriter(out: OutputStream) =
    new CSVWriter(this, out)

  //----------------------------------------------------------------

  def setDelimiter(delimiter: String) =
    new CSVFactory(quotes, delimiter, newLine, encoding)

  def setDelimiter(delimiter: Array[Char]): CSVFactory =
    setDelimiter(new String(delimiter))

  //----------------------------------------------------------------

  def setQuote(quotes: String) =
    new CSVFactory(quotes, delimiter, newLine,encoding)

  def setQuote(quotes: Array[Char]): CSVFactory =
    setQuote(new String(quotes))

  def setQuote(quotes: Char): CSVFactory =
    setQuote(quotes.toString)

  //----------------------------------------------------------------

  def setNewLine(newLine: String): CSVFactory =
    new CSVFactory(quotes, delimiter, newLine,encoding)

  def setNewLine(newLine: Array[Char]): CSVFactory =
    setNewLine(new String(newLine))

  def setNewLine(newLine: Char): CSVFactory =
    setNewLine(newLine.toString)

  //----------------------------------------------------------------

  def setEncoding(encoding: Charset): CSVFactory =
    new CSVFactory(quotes, delimiter, newLine,encoding)

  def setEncoding(encoding: String): CSVFactory =
    setEncoding(Charset.forName(encoding))

}
