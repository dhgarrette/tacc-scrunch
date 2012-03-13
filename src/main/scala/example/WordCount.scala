package example

import com.cloudera.crunch.io.{ From => from, To => to }
import com.cloudera.scrunch._
import com.cloudera.scrunch.Conversions._

class WordCount

object WordCount {
  def main(args: Array[String]) {
    val List(inputFile, outputFile) = args.toList

    val counts =
      new Pipeline[WordCount]
        .read(from.textFile(inputFile))
        .flatMap(_.toLowerCase.split("\\W+"))
        .filter(_.nonEmpty)
        .count

    counts.write(to.textFile(outputFile))

  }
}
