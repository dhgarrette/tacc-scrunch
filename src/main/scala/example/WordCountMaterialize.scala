package example

import com.cloudera.crunch.io.{ From => from }
import com.cloudera.scrunch._
import com.cloudera.scrunch.Conversions._

class WordCountMaterialize

object WordCountMaterialize {
  def main(args: Array[String]) {
    val List(inputFile) = args.toList

    val pipeline = new Pipeline[WordCountMaterialize]

    val counts =
      pipeline
        .read(from.textFile(inputFile))
        .flatMap(_.toLowerCase.split("\\W+"))
        .filter(_.nonEmpty)
        .count

    println(counts.materialize.toList)

    pipeline.done

  }
}
