package edu.stanford.nlp.pipeline;

import edu.stanford.nlp.util.StringUtils;

import java.util.Properties;

public class TokenizerGermanBenchmarkITest extends TokenizerBenchmarkTestCase {

  @Override
  public void setUp() {
    // set up the pipeline
    Properties props = StringUtils.argsToProperties("-props", "german");
    props.put("annotators", "tokenize,ssplit,mwt");
    props.put("ssplit.isOneSentence", "true");
    pipeline = new StanfordCoreNLP(props);
  }

  public void testOnDev() {
    goldFilePath = "/u/nlp/data/stanford-corenlp-testing/data/tokenize/de_gsd-ud-dev.conllu";
    runTest("dev", "de", 0.994);
  }

  public void testOnTest() {
    goldFilePath = "/u/nlp/data/stanford-corenlp-testing/data/tokenize/de_gsd-ud-test.conllu";
    runTest("test", "de", 0.995);
  }

}
