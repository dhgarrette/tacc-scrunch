/*
 * This was adapted from the scrunch source:
 * https://github.com/cloudera/crunch/blob/master/scrunch/examples/WordCount.scala
 */

import com.cloudera.scrunch.PipelineApp

object WordCount extends PipelineApp {

  val counts =
    read(from.textFile(args(0)))
      .flatMap(_.split("\\W+").filter(_.nonEmpty))
      .count

  write(counts, to.textFile(args(1)))

}

