package example

import com.cloudera.scrunch.{ From => from, To => to }
import com.cloudera.scrunch._
import com.cloudera.scrunch.Conversions._

class WordCount

object WordCount {
  def main(args: Array[String]) {
    val List(inputFile, outputFile) = args.toList

    val pipeline = new Pipeline[WordCount]

    val counts =
      pipeline
        .read(from.textFile(inputFile))
        .flatMap(_.toLowerCase.split("\\W+"))
        .filter(_.nonEmpty)
        .count

    val strings = counts.map { case (w, c) => "%s\t%d".format(w, c) }

    pipeline.writeTextFile(strings, outputFile)

    pipeline.done

  }
}
