# TACC-Scrunch

Author: **Dan Garrette** (dhg@cs.utexas.edu)


## Introduction

This is an example project for getting [Scrunch](https://github.com/cloudera/crunch/tree/master/scrunch) to work on [TACC](https://sites.google.com/site/tacchadoop/)


## Prerequisites

Scrunch requires a newer version of Hadoop than what is used on TACC by default.  By default, TACC uses Apache Hadoop 0.20.0.  Scrunch requires Cloudera Hadoop 0.20.2-cdh3u1.  We will use Cloudera Hadoop 0.20.2-cdh3u2.

To get this set up, do the following in your home directory:

    ln -s /scratch/01813/roller/software/lib/hadoop/hadoop-0.20.2-cdh3u2 hadoop
    
Add the following to `~/.profile_user` and `job.hadoop.new`:

    export HADOOP_HOME=/scratch/01813/roller/software/lib/hadoop/hadoop-0.20.2-cdh3u2


## Testing the setup

    $ echo "this is a test . this test is short ." > example.txt
    $ hadoop fs -put example.txt example.txt
    $ hadoop jar target/tacc-scrunch-assembly-0.0.1.jar example.WordCountMaterialize example.txt
    List((a,1), (is,2), (short,1), (test,2), (this,2))
    $ hadoop jar target/tacc-scrunch-assembly-0.0.1.jar example.WordCount example.txt example.wc
    $ hadoop fs -getmerge example.wc example.wc
    $ cat example.wc
 


