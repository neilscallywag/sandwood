package org.sandwood.compiler.tests.parser;

interface HMMTestPart3c$CoreInterface extends org.sandwood.runtime.internal.model.CoreModel {
	public double[] get$bias();
	public void set$bias(double[] cv$value);
	public boolean get$fixedFlag$sample17();
	public void set$fixedFlag$sample17(boolean cv$value);
	public boolean get$fixedFlag$sample26();
	public void set$fixedFlag$sample26(boolean cv$value);
	public boolean get$fixedFlag$sample35();
	public void set$fixedFlag$sample35(boolean cv$value);
	public boolean get$fixedFlag$sample48();
	public void set$fixedFlag$sample48(boolean cv$value);
	public boolean get$fixedFlag$sample57();
	public void set$fixedFlag$sample57(boolean cv$value);
	public boolean[] get$flips();
	public void set$flips(boolean[] cv$value);
	public boolean[] get$flipsMeasured();
	public void set$flipsMeasured(boolean[] cv$value);
	public int get$length$flipsMeasured();
	public void set$length$flipsMeasured(int cv$value);
	public double get$logProbability$bias();
	public double get$logProbability$flips();
	public double get$logProbability$m();
	public double get$logProbability$st();
	public double[][] get$m();
	public void set$m(double[][] cv$value);
	public int get$samples();
	public int[] get$st();
	public void set$st(int[] cv$value);
	public int get$states();
	public double[] get$v();
	public void logEvidenceGeneration();
}