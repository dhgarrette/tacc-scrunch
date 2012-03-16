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

    counts.map { case (w, c) => "%d\t%s".format(c, w) }.write(to.textFile(outputFile))

    pipeline.done

  }
}
