package org.sandwood.compiler.tests.parser;

interface NullModelMK2$CoreInterface extends org.sandwood.runtime.internal.model.CoreModel {

	// Getter for bias.
	public double get$bias();

	// Setter for bias.
	public void set$bias(double calculationVariable$value);

	// Getter for eta.
	public double get$eta();

	// Setter for eta.
	public void set$eta(double calculationVariable$value);

	// Getter for fixedFlag$sample10.
	public boolean get$fixedFlag$sample10();

	// Setter for fixedFlag$sample10.
	public void set$fixedFlag$sample10(boolean calculationVariable$value);

	// Getter for fixedFlag$sample12.
	public boolean get$fixedFlag$sample12();

	// Setter for fixedFlag$sample12.
	public void set$fixedFlag$sample12(boolean calculationVariable$value);

	// Getter for logProbability$bias.
	public double get$logProbability$bias();

	// Getter for logProbability$binomial.
	public double get$logProbability$binomial();

	// Getter for logProbability$positiveCount.
	public double get$logProbability$positiveCount();

	// Getter for min.
	public double get$min();

	// Getter for observedPositiveCount.
	public int get$observedPositiveCount();

	// Setter for observedPositiveCount.
	public void set$observedPositiveCount(int calculationVariable$value);

	// Getter for observedSampleCount.
	public int get$observedSampleCount();

	// Setter for observedSampleCount.
	public void set$observedSampleCount(int calculationVariable$value);

	// Getter for positiveCount.
	public int get$positiveCount();

	// Setter for positiveCount.
	public void set$positiveCount(int calculationVariable$value);

	// Method to generate a new random state for the model excluding any fixed values
	// and then calculate its probability.
	public void logEvidenceGeneration();
}