package org.sandwood.compiler.tests.parser;

import org.sandwood.random.internal.Rng;
import org.sandwood.runtime.internal.numericTools.Conjugates;
import org.sandwood.runtime.internal.numericTools.DistributionSampling;
import org.sandwood.runtime.model.ExecutionTarget;

class HMM$MultiThreadCPU extends org.sandwood.runtime.internal.model.CoreModelMultiThreadCPU implements HMM$CoreInterface {
	
	// Declare the variables for the model.
	private double[] bias;
	private double[][] cv$var16$countGlobal;
	private double[] cv$var33$stateProbabilityGlobal;
	private double[] cv$var43$stateProbabilityGlobal;
	private boolean fixedFlag$sample17 = false;
	private boolean fixedFlag$sample26 = false;
	private boolean fixedFlag$sample35 = false;
	private boolean fixedFlag$sample45 = false;
	private boolean fixedFlag$sample54 = false;
	private boolean fixedProbFlag$sample17 = false;
	private boolean fixedProbFlag$sample26 = false;
	private boolean fixedProbFlag$sample35 = false;
	private boolean fixedProbFlag$sample45 = false;
	private boolean fixedProbFlag$sample54 = false;
	private boolean[] flips;
	private int length$measured;
	private double logProbability$$evidence;
	private double logProbability$$model;
	private double logProbability$bias;
	private double logProbability$flips;
	private double logProbability$m;
	private double[] logProbability$sample45;
	private double[] logProbability$sample54;
	private double logProbability$st;
	private double logProbability$var11;
	private double logProbability$var16;
	private double logProbability$var20;
	private double logProbability$var25;
	private double logProbability$var32;
	private double logProbability$var33;
	private double[] logProbability$var42;
	private double[] logProbability$var51;
	private double[][] m;
	private boolean[] measured;
	private int samples;
	private boolean setFlag$bias = false;
	private boolean setFlag$flips = false;
	private boolean setFlag$m = false;
	private boolean setFlag$st = false;
	private int[] st;
	private int states;
	private boolean system$gibbsForward = true;
	private double[] v;

	public HMM$MultiThreadCPU(ExecutionTarget target) {
		super(target);
	}

	// Getter for bias.
	@Override
	public final double[] get$bias() {
		return bias;
	}

	// Setter for bias.
	@Override
	public final void set$bias(double[] cv$value) {
		// Set bias with flag to mark that it has been set so another array doesn't need to
		// be constructed
		bias = cv$value;
		setFlag$bias = true;
	}

	// Getter for fixedFlag$sample17.
	@Override
	public final boolean get$fixedFlag$sample17() {
		return fixedFlag$sample17;
	}

	// Setter for fixedFlag$sample17.
	@Override
	public final void set$fixedFlag$sample17(boolean cv$value) {
		// Set flags for all the side effects of fixedFlag$sample17 including if probabilities
		// need to be updated.
		fixedFlag$sample17 = cv$value;
		
		// Should the probability of sample 17 be set to fixed. This will only every change
		// the flag to false.
		// 
		// Substituted "fixedFlag$sample17" with its value "cv$value".
		fixedProbFlag$sample17 = (cv$value && fixedProbFlag$sample17);
		
		// Should the probability of sample 35 be set to fixed. This will only every change
		// the flag to false.
		// 
		// Substituted "fixedFlag$sample17" with its value "cv$value".
		fixedProbFlag$sample35 = (cv$value && fixedProbFlag$sample35);
		
		// Should the probability of sample 45 be set to fixed. This will only every change
		// the flag to false.
		// 
		// Substituted "fixedFlag$sample17" with its value "cv$value".
		fixedProbFlag$sample45 = (cv$value && fixedProbFlag$sample45);
	}

	// Getter for fixedFlag$sample26.
	@Override
	public final boolean get$fixedFlag$sample26() {
		return fixedFlag$sample26;
	}

	// Setter for fixedFlag$sample26.
	@Override
	public final void set$fixedFlag$sample26(boolean cv$value) {
		// Set flags for all the side effects of fixedFlag$sample26 including if probabilities
		// need to be updated.
		fixedFlag$sample26 = cv$value;
		
		// Should the probability of sample 26 be set to fixed. This will only every change
		// the flag to false.
		// 
		// Substituted "fixedFlag$sample26" with its value "cv$value".
		fixedProbFlag$sample26 = (cv$value && fixedProbFlag$sample26);
		
		// Should the probability of sample 54 be set to fixed. This will only every change
		// the flag to false.
		// 
		// Substituted "fixedFlag$sample26" with its value "cv$value".
		fixedProbFlag$sample54 = (cv$value && fixedProbFlag$sample54);
	}

	// Getter for fixedFlag$sample35.
	@Override
	public final boolean get$fixedFlag$sample35() {
		return fixedFlag$sample35;
	}

	// Setter for fixedFlag$sample35.
	@Override
	public final void set$fixedFlag$sample35(boolean cv$value) {
		// Set flags for all the side effects of fixedFlag$sample35 including if probabilities
		// need to be updated.
		fixedFlag$sample35 = cv$value;
		
		// Should the probability of sample 35 be set to fixed. This will only every change
		// the flag to false.
		// 
		// Substituted "fixedFlag$sample35" with its value "cv$value".
		fixedProbFlag$sample35 = (cv$value && fixedProbFlag$sample35);
		
		// Should the probability of sample 45 be set to fixed. This will only every change
		// the flag to false.
		// 
		// Substituted "fixedFlag$sample35" with its value "cv$value".
		fixedProbFlag$sample45 = (cv$value && fixedProbFlag$sample45);
		
		// Should the probability of sample 54 be set to fixed. This will only every change
		// the flag to false.
		// 
		// Substituted "fixedFlag$sample35" with its value "cv$value".
		fixedProbFlag$sample54 = (cv$value && fixedProbFlag$sample54);
	}

	// Getter for fixedFlag$sample45.
	@Override
	public final boolean get$fixedFlag$sample45() {
		return fixedFlag$sample45;
	}

	// Setter for fixedFlag$sample45.
	@Override
	public final void set$fixedFlag$sample45(boolean cv$value) {
		// Set flags for all the side effects of fixedFlag$sample45 including if probabilities
		// need to be updated.
		fixedFlag$sample45 = cv$value;
		
		// Should the probability of sample 45 be set to fixed. This will only every change
		// the flag to false.
		// 
		// Substituted "fixedFlag$sample45" with its value "cv$value".
		fixedProbFlag$sample45 = (cv$value && fixedProbFlag$sample45);
		
		// Should the probability of sample 54 be set to fixed. This will only every change
		// the flag to false.
		// 
		// Substituted "fixedFlag$sample45" with its value "cv$value".
		fixedProbFlag$sample54 = (cv$value && fixedProbFlag$sample54);
	}

	// Getter for fixedFlag$sample54.
	@Override
	public final boolean get$fixedFlag$sample54() {
		return fixedFlag$sample54;
	}

	// Setter for fixedFlag$sample54.
	@Override
	public final void set$fixedFlag$sample54(boolean cv$value) {
		// Set flags for all the side effects of fixedFlag$sample54 including if probabilities
		// need to be updated.
		fixedFlag$sample54 = cv$value;
		
		// Should the probability of sample 54 be set to fixed. This will only every change
		// the flag to false.
		// 
		// Substituted "fixedFlag$sample54" with its value "cv$value".
		fixedProbFlag$sample54 = (cv$value && fixedProbFlag$sample54);
	}

	// Getter for flips.
	@Override
	public final boolean[] get$flips() {
		return flips;
	}

	// Setter for flips.
	@Override
	public final void set$flips(boolean[] cv$value) {
		// Set flips with flag to mark that it has been set so another array doesn't need
		// to be constructed
		flips = cv$value;
		setFlag$flips = true;
	}

	// Getter for length$measured.
	@Override
	public final int get$length$measured() {
		return length$measured;
	}

	// Setter for length$measured.
	@Override
	public final void set$length$measured(int cv$value) {
		length$measured = cv$value;
	}

	// Getter for logProbability$$evidence.
	@Override
	public final double get$logProbability$$evidence() {
		return logProbability$$evidence;
	}

	// Getter for the probability of logProbability$$model.
	@Override
	public final double getCurrentLogProbability() {
		return logProbability$$model;
	}

	// Getter for logProbability$bias.
	@Override
	public final double get$logProbability$bias() {
		return logProbability$bias;
	}

	// Getter for logProbability$flips.
	@Override
	public final double get$logProbability$flips() {
		return logProbability$flips;
	}

	// Getter for logProbability$m.
	@Override
	public final double get$logProbability$m() {
		return logProbability$m;
	}

	// Getter for logProbability$st.
	@Override
	public final double get$logProbability$st() {
		return logProbability$st;
	}

	// Getter for m.
	@Override
	public final double[][] get$m() {
		return m;
	}

	// Setter for m.
	@Override
	public final void set$m(double[][] cv$value) {
		// Set m with flag to mark that it has been set so another array doesn't need to be
		// constructed
		m = cv$value;
		setFlag$m = true;
	}

	// Getter for measured.
	@Override
	public final boolean[] get$measured() {
		return measured;
	}

	// Setter for measured.
	@Override
	public final void set$measured(boolean[] cv$value) {
		// Set measured with flag to mark that it has been set so another array doesn't need
		// to be constructed
		measured = cv$value;
	}

	// Getter for samples.
	@Override
	public final int get$samples() {
		return samples;
	}

	// Getter for st.
	@Override
	public final int[] get$st() {
		return st;
	}

	// Setter for st.
	@Override
	public final void set$st(int[] cv$value) {
		// Set st with flag to mark that it has been set so another array doesn't need to
		// be constructed
		st = cv$value;
		setFlag$st = true;
	}

	// Getter for states.
	@Override
	public final int get$states() {
		return states;
	}

	// Setter for states.
	@Override
	public final void set$states(int cv$value) {
		states = cv$value;
	}

	// Getter for v.
	@Override
	public final double[] get$v() {
		return v;
	}

	// Calculate the probability of the samples represented by sample17 using sampled
	// values.
	private final void logProbabilityValue$sample17() {
		// Determine if we need to calculate the values for sample task 17 or if we should
		// just use cached values.
		if(!fixedProbFlag$sample17) {
			// Generating probabilities for sample task
			// Accumulator for sample probabilities for a specific instance of the random variable.
			double cv$sampleAccumulator = 0.0;
			for(int var15 = 0; var15 < states; var15 += 1)
				// Add the probability of this sample task to the sample task accumulator.
				// 
				// Scale the probability relative to the observed distribution space.
				// 
				// Add the probability of this distribution configuration to the accumulator.
				// 
				// An accumulator for the distributed probability space covered.
				// 
				// Variable declaration of cv$distributionAccumulator moved.
				// Declaration comment was:
				// An accumulator for log probabilities.
				// 
				// Store the value of the function call, so the function call is only made once.
				// 
				// The sample value to calculate the probability of generating
				cv$sampleAccumulator = (cv$sampleAccumulator + DistributionSampling.logProbabilityDirichlet(m[var15], v));
			logProbability$var11 = cv$sampleAccumulator;
			
			// Store the random variable instance probability
			logProbability$var16 = cv$sampleAccumulator;
			
			// Update the variable probability
			// 
			// Add the probability of this instance of the random variable to the probability
			// of all instances of the random variable.
			// 
			// Accumulator for probabilities of instances of the random variable
			logProbability$m = (logProbability$m + cv$sampleAccumulator);
			
			// Add probability to model
			// 
			// Add the probability of this instance of the random variable to the probability
			// of all instances of the random variable.
			// 
			// Accumulator for probabilities of instances of the random variable
			logProbability$$model = (logProbability$$model + cv$sampleAccumulator);
			
			// If this value is fixed, add it to the probability of this model producing the fixed
			// values
			if(fixedFlag$sample17)
				// Add the probability of this instance of the random variable to the probability
				// of all instances of the random variable.
				// 
				// Accumulator for probabilities of instances of the random variable
				logProbability$$evidence = (logProbability$$evidence + cv$sampleAccumulator);
			
			// Now the probability is calculated store if it can be cached or if it needs to be
			// recalculated next time.
			fixedProbFlag$sample17 = fixedFlag$sample17;
		}
		// Using cached values.
		else {
			// Updating random variable and model probabilities using cached probabilities for
			// this sample
			logProbability$var11 = logProbability$var16;
			
			// Update the variable probability
			// 
			// Variable declaration of cv$accumulator moved.
			logProbability$m = (logProbability$m + logProbability$var16);
			
			// Add probability to model
			// 
			// Variable declaration of cv$accumulator moved.
			logProbability$$model = (logProbability$$model + logProbability$var16);
			
			// If this value is fixed, add it to the probability of this model producing the fixed
			// values
			if(fixedFlag$sample17)
				// Variable declaration of cv$accumulator moved.
				logProbability$$evidence = (logProbability$$evidence + logProbability$var16);
		}
	}

	// Calculate the probability of the samples represented by sample26 using sampled
	// values.
	private final void logProbabilityValue$sample26() {
		// Determine if we need to calculate the values for sample task 26 or if we should
		// just use cached values.
		if(!fixedProbFlag$sample26) {
			// Generating probabilities for sample task
			// Accumulator for sample probabilities for a specific instance of the random variable.
			double cv$sampleAccumulator = 0.0;
			for(int var24 = 0; var24 < states; var24 += 1)
				// Add the probability of this sample task to the sample task accumulator.
				// 
				// Scale the probability relative to the observed distribution space.
				// 
				// Add the probability of this distribution configuration to the accumulator.
				// 
				// An accumulator for the distributed probability space covered.
				// 
				// Variable declaration of cv$distributionAccumulator moved.
				// Declaration comment was:
				// An accumulator for log probabilities.
				// 
				// Store the value of the function call, so the function call is only made once.
				// 
				// The sample value to calculate the probability of generating
				cv$sampleAccumulator = (cv$sampleAccumulator + DistributionSampling.logProbabilityBeta(bias[var24], 1.0, 1.0));
			logProbability$var20 = cv$sampleAccumulator;
			
			// Store the random variable instance probability
			logProbability$var25 = cv$sampleAccumulator;
			
			// Update the variable probability
			// 
			// Add the probability of this instance of the random variable to the probability
			// of all instances of the random variable.
			// 
			// Accumulator for probabilities of instances of the random variable
			logProbability$bias = (logProbability$bias + cv$sampleAccumulator);
			
			// Add probability to model
			// 
			// Add the probability of this instance of the random variable to the probability
			// of all instances of the random variable.
			// 
			// Accumulator for probabilities of instances of the random variable
			logProbability$$model = (logProbability$$model + cv$sampleAccumulator);
			
			// If this value is fixed, add it to the probability of this model producing the fixed
			// values
			if(fixedFlag$sample26)
				// Add the probability of this instance of the random variable to the probability
				// of all instances of the random variable.
				// 
				// Accumulator for probabilities of instances of the random variable
				logProbability$$evidence = (logProbability$$evidence + cv$sampleAccumulator);
			
			// Now the probability is calculated store if it can be cached or if it needs to be
			// recalculated next time.
			fixedProbFlag$sample26 = fixedFlag$sample26;
		}
		// Using cached values.
		else {
			// Updating random variable and model probabilities using cached probabilities for
			// this sample
			logProbability$var20 = logProbability$var25;
			
			// Update the variable probability
			// 
			// Variable declaration of cv$accumulator moved.
			logProbability$bias = (logProbability$bias + logProbability$var25);
			
			// Add probability to model
			// 
			// Variable declaration of cv$accumulator moved.
			logProbability$$model = (logProbability$$model + logProbability$var25);
			
			// If this value is fixed, add it to the probability of this model producing the fixed
			// values
			if(fixedFlag$sample26)
				// Variable declaration of cv$accumulator moved.
				logProbability$$evidence = (logProbability$$evidence + logProbability$var25);
		}
	}

	// Calculate the probability of the samples represented by sample35 using sampled
	// values.
	private final void logProbabilityValue$sample35() {
		// Determine if we need to calculate the values for sample task 35 or if we should
		// just use cached values.
		if(!fixedProbFlag$sample35) {
			// Generating probabilities for sample task
			// Variable declaration of cv$distributionAccumulator moved.
			// Declaration comment was:
			// Variable declaration of cv$distributionAccumulator moved.
			// Declaration comment was:
			// An accumulator for log probabilities.
			// 
			// Store the value of the function call, so the function call is only made once.
			// 
			// The sample value to calculate the probability of generating
			// 
			// Scale the probability relative to the observed distribution space.
			// 
			// Add the probability of this distribution configuration to the accumulator.
			// 
			// An accumulator for the distributed probability space covered.
			// 
			// Variable declaration of cv$distributionAccumulator moved.
			// Declaration comment was:
			// An accumulator for log probabilities.
			// 
			// Store the value of the function call, so the function call is only made once.
			// 
			// The sample value to calculate the probability of generating
			double cv$distributionAccumulator = DistributionSampling.logProbabilityCategorical(st[0], m[0]);
			
			// Add the probability of this sample task to the sample task accumulator.
			// 
			// Accumulator for sample probabilities for a specific instance of the random variable.
			logProbability$var32 = cv$distributionAccumulator;
			
			// Store the sample task probability
			logProbability$var33 = cv$distributionAccumulator;
			
			// Update the variable probability
			// 
			// Variable declaration of cv$accumulator moved.
			// Declaration comment was:
			// Accumulator for probabilities of instances of the random variable
			// 
			// Add the probability of this instance of the random variable to the probability
			// of all instances of the random variable.
			// 
			// Accumulator for probabilities of instances of the random variable
			// 
			// Add the probability of this sample task to the sample task accumulator.
			// 
			// Accumulator for sample probabilities for a specific instance of the random variable.
			logProbability$st = (logProbability$st + cv$distributionAccumulator);
			
			// Add probability to model
			// 
			// Variable declaration of cv$accumulator moved.
			// Declaration comment was:
			// Accumulator for probabilities of instances of the random variable
			// 
			// Add the probability of this instance of the random variable to the probability
			// of all instances of the random variable.
			// 
			// Accumulator for probabilities of instances of the random variable
			// 
			// Add the probability of this sample task to the sample task accumulator.
			// 
			// Accumulator for sample probabilities for a specific instance of the random variable.
			logProbability$$model = (logProbability$$model + cv$distributionAccumulator);
			
			// If this value is fixed, add it to the probability of this model producing the fixed
			// values
			if(fixedFlag$sample35)
				// Variable declaration of cv$accumulator moved.
				// Declaration comment was:
				// Accumulator for probabilities of instances of the random variable
				// 
				// Add the probability of this instance of the random variable to the probability
				// of all instances of the random variable.
				// 
				// Accumulator for probabilities of instances of the random variable
				// 
				// Add the probability of this sample task to the sample task accumulator.
				// 
				// Accumulator for sample probabilities for a specific instance of the random variable.
				logProbability$$evidence = (logProbability$$evidence + cv$distributionAccumulator);
			
			// Now the probability is calculated store if it can be cached or if it needs to be
			// recalculated next time.
			fixedProbFlag$sample35 = (fixedFlag$sample35 && fixedFlag$sample17);
		}
		// Using cached values.
		else {
			// Updating random variable and model probabilities using cached probabilities for
			// this sample
			logProbability$var32 = logProbability$var33;
			
			// Update the variable probability
			// 
			// Variable declaration of cv$accumulator moved.
			logProbability$st = (logProbability$st + logProbability$var33);
			
			// Add probability to model
			// 
			// Variable declaration of cv$accumulator moved.
			logProbability$$model = (logProbability$$model + logProbability$var33);
			
			// If this value is fixed, add it to the probability of this model producing the fixed
			// values
			if(fixedFlag$sample35)
				// Variable declaration of cv$accumulator moved.
				logProbability$$evidence = (logProbability$$evidence + logProbability$var33);
		}
	}

	// Calculate the probability of the samples represented by sample45 using sampled
	// values.
	private final void logProbabilityValue$sample45() {
		// Determine if we need to calculate the values for sample task 45 or if we should
		// just use cached values.
		if(!fixedProbFlag$sample45) {
			// Generating probabilities for sample task
			// Accumulator for probabilities of instances of the random variable
			double cv$accumulator = 0.0;
			for(int i = 1; i < samples; i += 1) {
				// Variable declaration of cv$distributionAccumulator moved.
				// Declaration comment was:
				// Variable declaration of cv$distributionAccumulator moved.
				// Declaration comment was:
				// An accumulator for log probabilities.
				// 
				// Store the value of the function call, so the function call is only made once.
				// 
				// The sample value to calculate the probability of generating
				// 
				// Scale the probability relative to the observed distribution space.
				// 
				// Add the probability of this distribution configuration to the accumulator.
				// 
				// An accumulator for the distributed probability space covered.
				// 
				// Variable declaration of cv$distributionAccumulator moved.
				// Declaration comment was:
				// An accumulator for log probabilities.
				// 
				// Store the value of the function call, so the function call is only made once.
				// 
				// The sample value to calculate the probability of generating
				double cv$distributionAccumulator = DistributionSampling.logProbabilityCategorical(st[i], m[st[(i - 1)]]);
				
				// Add the probability of this instance of the random variable to the probability
				// of all instances of the random variable.
				// 
				// Add the probability of this sample task to the sample task accumulator.
				// 
				// Accumulator for sample probabilities for a specific instance of the random variable.
				cv$accumulator = (cv$accumulator + cv$distributionAccumulator);
				
				// Add the probability of this sample task to the sample task accumulator.
				// 
				// Accumulator for sample probabilities for a specific instance of the random variable.
				logProbability$var42[(i - 1)] = cv$distributionAccumulator;
				
				// Store the sample task probability
				logProbability$sample45[(i - 1)] = cv$distributionAccumulator;
			}
			
			// Update the variable probability
			logProbability$st = (logProbability$st + cv$accumulator);
			
			// Add probability to model
			logProbability$$model = (logProbability$$model + cv$accumulator);
			
			// If this value is fixed, add it to the probability of this model producing the fixed
			// values
			if(fixedFlag$sample45)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			
			// Now the probability is calculated store if it can be cached or if it needs to be
			// recalculated next time.
			fixedProbFlag$sample45 = ((fixedFlag$sample45 && fixedFlag$sample17) && fixedFlag$sample35);
		}
		// Using cached values.
		else {
			// Updating random variable and model probabilities using cached probabilities for
			// this sample
			double cv$accumulator = 0.0;
			for(int i = 1; i < samples; i += 1) {
				// Variable declaration of cv$rvAccumulator moved.
				double cv$rvAccumulator = logProbability$sample45[(i - 1)];
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var42[(i - 1)] = cv$rvAccumulator;
			}
			
			// Update the variable probability
			logProbability$st = (logProbability$st + cv$accumulator);
			
			// Add probability to model
			logProbability$$model = (logProbability$$model + cv$accumulator);
			
			// If this value is fixed, add it to the probability of this model producing the fixed
			// values
			if(fixedFlag$sample45)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	// Calculate the probability of the samples represented by sample54 using sampled
	// values.
	private final void logProbabilityValue$sample54() {
		// Determine if we need to calculate the values for sample task 54 or if we should
		// just use cached values.
		if(!fixedProbFlag$sample54) {
			// Generating probabilities for sample task
			// Accumulator for probabilities of instances of the random variable
			double cv$accumulator = 0.0;
			for(int j = 0; j < samples; j += 1) {
				// Variable declaration of cv$distributionAccumulator moved.
				// Declaration comment was:
				// Variable declaration of cv$distributionAccumulator moved.
				// Declaration comment was:
				// An accumulator for log probabilities.
				// 
				// Store the value of the function call, so the function call is only made once.
				// 
				// The sample value to calculate the probability of generating
				// 
				// Scale the probability relative to the observed distribution space.
				// 
				// Add the probability of this distribution configuration to the accumulator.
				// 
				// An accumulator for the distributed probability space covered.
				// 
				// Variable declaration of cv$distributionAccumulator moved.
				// Declaration comment was:
				// An accumulator for log probabilities.
				// 
				// Store the value of the function call, so the function call is only made once.
				// 
				// The sample value to calculate the probability of generating
				double cv$distributionAccumulator = DistributionSampling.logProbabilityBernoulli(flips[j], bias[st[j]]);
				
				// Add the probability of this instance of the random variable to the probability
				// of all instances of the random variable.
				// 
				// Add the probability of this sample task to the sample task accumulator.
				// 
				// Accumulator for sample probabilities for a specific instance of the random variable.
				cv$accumulator = (cv$accumulator + cv$distributionAccumulator);
				
				// Add the probability of this sample task to the sample task accumulator.
				// 
				// Accumulator for sample probabilities for a specific instance of the random variable.
				logProbability$var51[j] = cv$distributionAccumulator;
				
				// Store the sample task probability
				logProbability$sample54[j] = cv$distributionAccumulator;
			}
			
			// Update the variable probability
			logProbability$flips = (logProbability$flips + cv$accumulator);
			
			// Add probability to model
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			
			// Now the probability is calculated store if it can be cached or if it needs to be
			// recalculated next time.
			fixedProbFlag$sample54 = (((fixedFlag$sample54 && fixedFlag$sample26) && fixedFlag$sample35) && fixedFlag$sample45);
		}
		// Using cached values.
		else {
			// Updating random variable and model probabilities using cached probabilities for
			// this sample
			double cv$accumulator = 0.0;
			for(int j = 0; j < samples; j += 1) {
				// Variable declaration of cv$rvAccumulator moved.
				double cv$rvAccumulator = logProbability$sample54[j];
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var51[j] = cv$rvAccumulator;
			}
			
			// Update the variable probability
			logProbability$flips = (logProbability$flips + cv$accumulator);
			
			// Add probability to model
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	// Method to perform the inference steps to calculate new values for the samples generated
	// by sample task 17 drawn from Dirichlet 11. Inference was performed using a Dirichlet
	// to Categorical conjugate prior.
	private final void sample17(int var15, int threadID$cv$var15, Rng RNG$) {
		// A local reference to the scratch space.
		double[] cv$countLocal = cv$var16$countGlobal[threadID$cv$var15];
		
		// Initialize the array values to 0.
		// 
		// Get the length of the array
		for(int cv$loopIndex = 0; cv$loopIndex < states; cv$loopIndex += 1)
			cv$countLocal[cv$loopIndex] = 0.0;
		
		// Constraints moved from conditionals in inner loops/scopes/etc.
		if((var15 == 0))
			// Looking for a path between Sample 17 and consumer Categorical 32.
			// 
			// Processing sample task 35 of consumer random variable null.
			// 
			// Increment the sample counter with the value sampled by sample task 35 of random
			// variable var32
			cv$countLocal[st[0]] = (cv$countLocal[st[0]] + 1.0);
		
		// Processing random variable 42.
		// 
		// Looking for a path between Sample 17 and consumer Categorical 42.
		for(int i = 1; i < samples; i += 1) {
			if((var15 == st[(i - 1)]))
				// Processing sample task 45 of consumer random variable null.
				// 
				// Increment the sample counter with the value sampled by sample task 45 of random
				// variable var42
				cv$countLocal[st[i]] = (cv$countLocal[st[i]] + 1.0);
		}
		
		// Calculate the new sample value
		// 
		// Calculate a new sample value and write it into cv$targetLocal.
		// 
		// A reference local to the function for the sample variable.
		Conjugates.sampleConjugateDirichletCategorical(RNG$, v, cv$countLocal, m[var15]);
	}

	// Method to perform the inference steps to calculate new values for the samples generated
	// by sample task 26 drawn from Beta 20. Inference was performed using a Beta to Bernoulli/Binomial
	// conjugate prior.
	private final void sample26(int var24, int threadID$cv$var24, Rng RNG$) {
		// Local variable to record the number of true samples.
		int cv$sum = 0;
		
		// Local variable to record the number of samples.
		int cv$count = 0;
		
		// Processing random variable 51.
		// 
		// Looking for a path between Sample 26 and consumer Bernoulli 51.
		for(int j = 0; j < samples; j += 1) {
			if((var24 == st[j])) {
				// Processing sample task 54 of consumer random variable null.
				// 
				// Include the value sampled by task 54 from random variable var51.
				// Increment the number of samples.
				cv$count = (cv$count + 1);
				
				// If the sample value was positive increase the count
				if(flips[j])
					cv$sum = (cv$sum + 1);
			}
		}
		
		// Write out the value of the sample to a temporary variable prior to updating the
		// intermediate variables.
		bias[var24] = Conjugates.sampleConjugateBetaBinomial(RNG$, 1.0, 1.0, cv$sum, cv$count);
	}

	// Method to perform the inference steps to calculate new values for the samples generated
	// by sample task 35 drawn from Categorical 32. Inference was performed using variable
	// marginalization.
	private final void sample35() {
		for(int cv$valuePos = 0; cv$valuePos < states; cv$valuePos += 1) {
			// Value of the variable at this index
			st[0] = cv$valuePos;
			
			// An accumulator to allow the value for each distribution to be constructed before
			// it is added to the index probabilities.
			// 
			// Value of the variable at this index
			// 
			// cv$temp$0$var31's comment
			// Constructing a random variable input for use later.
			double cv$accumulatedProbabilities = DistributionSampling.logProbabilityCategorical(cv$valuePos, m[0]);
			
			// Substituted "i" with its value "1".
			if((1 < samples))
				// Processing sample task 45 of consumer random variable null.
				// 
				// A check to ensure rounding of floating point values can never result in a negative
				// value.
				// 
				// Recorded the probability of reaching sample task 45 with the current configuration.
				// 
				// Set an accumulator to record the consumer distributions not seen. Initially set
				// to 1 as seen values will be deducted from this value.
				// 
				// Variable declaration of cv$accumulatedConsumerProbabilities moved.
				// Declaration comment was:
				// Set an accumulator to sum the probabilities for each possible configuration of
				// inputs.
				// 
				// Substituted "i" with its value "1".
				// 
				// cv$temp$1$var41's comment
				// Variable declaration of cv$temp$1$var41 moved.
				// 
				// Constructing a random variable input for use later.
				// 
				// Processing random variable 42.
				// 
				// Looking for a path between Sample 35 and consumer Categorical 42.
				// 
				// Value of the variable at this index
				cv$accumulatedProbabilities = (DistributionSampling.logProbabilityCategorical(st[1], m[cv$valuePos]) + cv$accumulatedProbabilities);
			
			// Substituted "j" with its value "0".
			if((0 < samples))
				// Processing sample task 54 of consumer random variable null.
				// 
				// A check to ensure rounding of floating point values can never result in a negative
				// value.
				// 
				// Recorded the probability of reaching sample task 54 with the current configuration.
				// 
				// Set an accumulator to record the consumer distributions not seen. Initially set
				// to 1 as seen values will be deducted from this value.
				// 
				// Variable declaration of cv$accumulatedConsumerProbabilities moved.
				// Declaration comment was:
				// Set an accumulator to sum the probabilities for each possible configuration of
				// inputs.
				// 
				// Substituted "j" with its value "0".
				// 
				// cv$temp$2$var50's comment
				// Variable declaration of cv$temp$2$var50 moved.
				// 
				// Constructing a random variable input for use later.
				// 
				// Processing random variable 51.
				// 
				// Looking for a path between Sample 35 and consumer Bernoulli 51.
				// 
				// Value of the variable at this index
				cv$accumulatedProbabilities = (DistributionSampling.logProbabilityBernoulli(flips[0], bias[cv$valuePos]) + cv$accumulatedProbabilities);
			
			// Save the calculated index value into the array of index value probabilities
			// 
			// Get a local reference to the scratch space.
			// 
			// Record the reached probability density.
			// 
			// Initialize a counter to track the reached distributions.
			cv$var33$stateProbabilityGlobal[cv$valuePos] = cv$accumulatedProbabilities;
		}
		
		// This value is not used before it is set again, so removing the value declaration.
		// 
		// The sum of all the probabilities in log space
		double cv$logSum;
		
		// Sum all the values
		// 
		// Initialise the max to the first element.
		// 
		// Get a local reference to the scratch space.
		double cv$lseMax = cv$var33$stateProbabilityGlobal[0];
		
		// Find max value.
		// 
		// Get a local reference to the scratch space.
		for(int cv$lseIndex = 1; cv$lseIndex < cv$var33$stateProbabilityGlobal.length; cv$lseIndex += 1) {
			// Get a local reference to the scratch space.
			double cv$lseElementValue = cv$var33$stateProbabilityGlobal[cv$lseIndex];
			if((cv$lseMax < cv$lseElementValue))
				cv$lseMax = cv$lseElementValue;
		}
		
		// If the maximum value is -infinity return -infinity.
		if((cv$lseMax == Double.NEGATIVE_INFINITY))
			cv$logSum = Double.NEGATIVE_INFINITY;
		
		// Sum the values in the array.
		else {
			// Initialise the sum of the array elements
			double cv$lseSum = 0.0;
			
			// Offset values, move to normal space, and sum.
			// 
			// Get a local reference to the scratch space.
			for(int cv$lseIndex = 0; cv$lseIndex < cv$var33$stateProbabilityGlobal.length; cv$lseIndex += 1)
				// Get a local reference to the scratch space.
				cv$lseSum = (cv$lseSum + Math.exp((cv$var33$stateProbabilityGlobal[cv$lseIndex] - cv$lseMax)));
			
			// Increment the value of the target, moving the value back into log space.
			// 
			// The sum of all the probabilities in log space
			cv$logSum = (Math.log(cv$lseSum) + cv$lseMax);
		}
		
		// If all the sum is zero, just share the probability evenly.
		if((cv$logSum == Double.NEGATIVE_INFINITY)) {
			// Normalize log space values and move to normal space
			// 
			// Get a local reference to the scratch space.
			for(int cv$indexName = 0; cv$indexName < cv$var33$stateProbabilityGlobal.length; cv$indexName += 1)
				// Get a local reference to the scratch space.
				cv$var33$stateProbabilityGlobal[cv$indexName] = (1.0 / cv$var33$stateProbabilityGlobal.length);
		} else {
			// Normalize log space values and move to normal space
			// 
			// Get a local reference to the scratch space.
			for(int cv$indexName = 0; cv$indexName < cv$var33$stateProbabilityGlobal.length; cv$indexName += 1)
				// Get a local reference to the scratch space.
				cv$var33$stateProbabilityGlobal[cv$indexName] = Math.exp((cv$var33$stateProbabilityGlobal[cv$indexName] - cv$logSum));
		}
		
		// Write out the value of the sample to a temporary variable prior to updating the
		// intermediate variables.
		// 
		// Get a local reference to the scratch space.
		st[0] = DistributionSampling.sampleCategorical(RNG$, cv$var33$stateProbabilityGlobal);
	}

	// Method to perform the inference steps to calculate new values for the samples generated
	// by sample task 45 drawn from Categorical 42. Inference was performed using variable
	// marginalization.
	private final void sample45(int i) {
		for(int cv$valuePos = 0; cv$valuePos < states; cv$valuePos += 1) {
			// Value of the variable at this index
			st[i] = cv$valuePos;
			
			// An accumulator to allow the value for each distribution to be constructed before
			// it is added to the index probabilities.
			// 
			// Value of the variable at this index
			// 
			// cv$temp$0$var41's comment
			// Constructing a random variable input for use later.
			double cv$accumulatedProbabilities = DistributionSampling.logProbabilityCategorical(cv$valuePos, m[st[(i - 1)]]);
			int index$i$1_2 = (i + 1);
			if((index$i$1_2 < samples))
				// Processing sample task 45 of consumer random variable null.
				// 
				// A check to ensure rounding of floating point values can never result in a negative
				// value.
				// 
				// Recorded the probability of reaching sample task 45 with the current configuration.
				// 
				// Set an accumulator to record the consumer distributions not seen. Initially set
				// to 1 as seen values will be deducted from this value.
				// 
				// Variable declaration of cv$accumulatedConsumerProbabilities moved.
				// Declaration comment was:
				// Set an accumulator to sum the probabilities for each possible configuration of
				// inputs.
				// 
				// cv$temp$1$var41's comment
				// Variable declaration of cv$temp$1$var41 moved.
				// 
				// Constructing a random variable input for use later.
				// 
				// Processing random variable 42.
				// 
				// Looking for a path between Sample 45 and consumer Categorical 42.
				// 
				// Value of the variable at this index
				cv$accumulatedProbabilities = (DistributionSampling.logProbabilityCategorical(st[index$i$1_2], m[cv$valuePos]) + cv$accumulatedProbabilities);
			
			// A check to ensure rounding of floating point values can never result in a negative
			// value.
			// 
			// Recorded the probability of reaching sample task 54 with the current configuration.
			// 
			// Set an accumulator to record the consumer distributions not seen. Initially set
			// to 1 as seen values will be deducted from this value.
			// 
			// Variable declaration of cv$accumulatedConsumerProbabilities moved.
			// Declaration comment was:
			// Processing sample task 54 of consumer random variable null.
			// 
			// Set an accumulator to sum the probabilities for each possible configuration of
			// inputs.
			// 
			// Substituted "j" with its value "i".
			// 
			// cv$temp$2$var50's comment
			// Variable declaration of cv$temp$2$var50 moved.
			// 
			// Constructing a random variable input for use later.
			// 
			// Processing random variable 51.
			// 
			// Looking for a path between Sample 45 and consumer Bernoulli 51.
			// 
			// Value of the variable at this index
			cv$accumulatedProbabilities = (DistributionSampling.logProbabilityBernoulli(flips[i], bias[cv$valuePos]) + cv$accumulatedProbabilities);
			
			// Save the calculated index value into the array of index value probabilities
			// 
			// Get a local reference to the scratch space.
			// 
			// Record the reached probability density.
			// 
			// Initialize a counter to track the reached distributions.
			cv$var43$stateProbabilityGlobal[cv$valuePos] = cv$accumulatedProbabilities;
		}
		
		// This value is not used before it is set again, so removing the value declaration.
		// 
		// The sum of all the probabilities in log space
		double cv$logSum;
		
		// Sum all the values
		// 
		// Initialise the max to the first element.
		// 
		// Get a local reference to the scratch space.
		double cv$lseMax = cv$var43$stateProbabilityGlobal[0];
		
		// Find max value.
		// 
		// Get a local reference to the scratch space.
		for(int cv$lseIndex = 1; cv$lseIndex < cv$var43$stateProbabilityGlobal.length; cv$lseIndex += 1) {
			// Get a local reference to the scratch space.
			double cv$lseElementValue = cv$var43$stateProbabilityGlobal[cv$lseIndex];
			if((cv$lseMax < cv$lseElementValue))
				cv$lseMax = cv$lseElementValue;
		}
		
		// If the maximum value is -infinity return -infinity.
		if((cv$lseMax == Double.NEGATIVE_INFINITY))
			cv$logSum = Double.NEGATIVE_INFINITY;
		
		// Sum the values in the array.
		else {
			// Initialise the sum of the array elements
			double cv$lseSum = 0.0;
			
			// Offset values, move to normal space, and sum.
			// 
			// Get a local reference to the scratch space.
			for(int cv$lseIndex = 0; cv$lseIndex < cv$var43$stateProbabilityGlobal.length; cv$lseIndex += 1)
				// Get a local reference to the scratch space.
				cv$lseSum = (cv$lseSum + Math.exp((cv$var43$stateProbabilityGlobal[cv$lseIndex] - cv$lseMax)));
			
			// Increment the value of the target, moving the value back into log space.
			// 
			// The sum of all the probabilities in log space
			cv$logSum = (Math.log(cv$lseSum) + cv$lseMax);
		}
		
		// If all the sum is zero, just share the probability evenly.
		if((cv$logSum == Double.NEGATIVE_INFINITY)) {
			// Normalize log space values and move to normal space
			// 
			// Get a local reference to the scratch space.
			for(int cv$indexName = 0; cv$indexName < cv$var43$stateProbabilityGlobal.length; cv$indexName += 1)
				// Get a local reference to the scratch space.
				cv$var43$stateProbabilityGlobal[cv$indexName] = (1.0 / cv$var43$stateProbabilityGlobal.length);
		} else {
			// Normalize log space values and move to normal space
			// 
			// Get a local reference to the scratch space.
			for(int cv$indexName = 0; cv$indexName < cv$var43$stateProbabilityGlobal.length; cv$indexName += 1)
				// Get a local reference to the scratch space.
				cv$var43$stateProbabilityGlobal[cv$indexName] = Math.exp((cv$var43$stateProbabilityGlobal[cv$indexName] - cv$logSum));
		}
		
		// Write out the value of the sample to a temporary variable prior to updating the
		// intermediate variables.
		// 
		// Get a local reference to the scratch space.
		st[i] = DistributionSampling.sampleCategorical(RNG$, cv$var43$stateProbabilityGlobal);
	}

	// Method to allocate space temporary variables used by the inference methods. Allocating
	// here prevents repeated allocation and deallocation, and makes the code more amenable
	// to GPU execution.
	@Override
	public final void allocateScratch() {
		// Allocate scratch space.
		// Constructor for cv$var16$countGlobal
		// 
		// Calculate the longest array this random variable could produce and allocate an
		// array large enough to handle this.
		int cv$max = 0;
		if((0 < states))
			cv$max = states;
		
		// Allocation of cv$var16$countGlobal for multithreaded execution
		// 
		// Get the thread count.
		int cv$threadCount = threadCount();
		
		// Allocate an array to hold a copy per thread
		cv$var16$countGlobal = new double[cv$threadCount][];
		
		// Populate the array with a copy per thread
		for(int cv$index = 0; cv$index < cv$threadCount; cv$index += 1)
			cv$var16$countGlobal[cv$index] = new double[cv$max];
		
		// Constructor for cv$var33$stateProbabilityGlobal
		// 
		// Allocation of cv$var33$stateProbabilityGlobal for single threaded execution
		// 
		// Variable to record the maximum value of Task Get 33. Initially set to the value
		// of putTask 18.
		cv$var33$stateProbabilityGlobal = new double[states];
		
		// Allocation of cv$var43$stateProbabilityGlobal for single threaded execution
		// 
		// Variable to record the maximum value of Task Get 43. Initially set to the value
		// of putTask 18.
		cv$var43$stateProbabilityGlobal = new double[states];
	}

	// Method to allocate space for model inputs and outputs.
	@Override
	public final void allocator() {
		// Constructor for v
		v = new double[states];
		
		// If m has not been set already allocate space.
		if(!setFlag$m) {
			// Constructor for m
			m = new double[states][];
			for(int var15 = 0; var15 < states; var15 += 1)
				m[var15] = new double[states];
		}
		
		// If bias has not been set already allocate space.
		if(!setFlag$bias)
			// Constructor for bias
			bias = new double[states];
		
		// If st has not been set already allocate space.
		if(!setFlag$st)
			// Constructor for st
			st = new int[length$measured];
		
		// If flips has not been set already allocate space.
		if(!setFlag$flips)
			// Constructor for flips
			flips = new boolean[length$measured];
		
		// Constructor for logProbability$var42
		logProbability$var42 = new double[(length$measured - 1)];
		
		// Constructor for logProbability$sample45
		logProbability$sample45 = new double[(length$measured - 1)];
		
		// Constructor for logProbability$var51
		logProbability$var51 = new double[length$measured];
		
		// Constructor for logProbability$sample54
		logProbability$sample54 = new double[length$measured];
		
		// Allocate scratch space
		allocateScratch();
	}

	// Method to execute the model code conventionally.
	@Override
	public final void forwardGeneration() {
		// Constraints moved from conditionals in inner loops/scopes/etc.
		if(!fixedFlag$sample17)
			//  Outer loop for dispatching multiple batches of iterations to execute in parallel
			parallelFor(RNG$, 0, states, 1,
				(int forStart$var15, int forEnd$var15, int threadID$var15, org.sandwood.random.internal.Rng RNG$1) -> { 
					
						// Inner loop for running batches of iterations, each batch has its own random number
						// generator.
						for(int var15 = forStart$var15; var15 < forEnd$var15; var15 += 1)
							DistributionSampling.sampleDirichlet(RNG$1, v, m[var15]);
				}
			);

		
		// Constraints moved from conditionals in inner loops/scopes/etc.
		if(!fixedFlag$sample26)
			//  Outer loop for dispatching multiple batches of iterations to execute in parallel
			parallelFor(RNG$, 0, states, 1,
				(int forStart$var24, int forEnd$var24, int threadID$var24, org.sandwood.random.internal.Rng RNG$1) -> { 
					
						// Inner loop for running batches of iterations, each batch has its own random number
						// generator.
						for(int var24 = forStart$var24; var24 < forEnd$var24; var24 += 1)
							bias[var24] = DistributionSampling.sampleBeta(RNG$1, 1.0, 1.0);
				}
			);

		if(!fixedFlag$sample35)
			st[0] = DistributionSampling.sampleCategorical(RNG$, m[0]);
		
		// Constraints moved from conditionals in inner loops/scopes/etc.
		if(!fixedFlag$sample45) {
			for(int i = 1; i < samples; i += 1)
				st[i] = DistributionSampling.sampleCategorical(RNG$, m[st[(i - 1)]]);
		}
		
		// Constraints moved from conditionals in inner loops/scopes/etc.
		if(!fixedFlag$sample54)
			//  Outer loop for dispatching multiple batches of iterations to execute in parallel
			parallelFor(RNG$, 0, samples, 1,
				(int forStart$j, int forEnd$j, int threadID$j, org.sandwood.random.internal.Rng RNG$1) -> { 
					
						// Inner loop for running batches of iterations, each batch has its own random number
						// generator.
						for(int j = forStart$j; j < forEnd$j; j += 1)
							flips[j] = DistributionSampling.sampleBernoulli(RNG$1, bias[st[j]]);
				}
			);

	}

	// Method to execute the model code conventionally, excluding the elements that generate
	// observed values. Distributions are calculated and stored.
	@Override
	public final void forwardGenerationDistributionsNoOutputs() {
		// Constraints moved from conditionals in inner loops/scopes/etc.
		if(!fixedFlag$sample17)
			//  Outer loop for dispatching multiple batches of iterations to execute in parallel
			parallelFor(RNG$, 0, states, 1,
				(int forStart$var15, int forEnd$var15, int threadID$var15, org.sandwood.random.internal.Rng RNG$1) -> { 
					
						// Inner loop for running batches of iterations, each batch has its own random number
						// generator.
						for(int var15 = forStart$var15; var15 < forEnd$var15; var15 += 1)
							DistributionSampling.sampleDirichlet(RNG$1, v, m[var15]);
				}
			);

		
		// Constraints moved from conditionals in inner loops/scopes/etc.
		if(!fixedFlag$sample26)
			//  Outer loop for dispatching multiple batches of iterations to execute in parallel
			parallelFor(RNG$, 0, states, 1,
				(int forStart$var24, int forEnd$var24, int threadID$var24, org.sandwood.random.internal.Rng RNG$1) -> { 
					
						// Inner loop for running batches of iterations, each batch has its own random number
						// generator.
						for(int var24 = forStart$var24; var24 < forEnd$var24; var24 += 1)
							bias[var24] = DistributionSampling.sampleBeta(RNG$1, 1.0, 1.0);
				}
			);

		if(!fixedFlag$sample35)
			st[0] = DistributionSampling.sampleCategorical(RNG$, m[0]);
		
		// Constraints moved from conditionals in inner loops/scopes/etc.
		if(!fixedFlag$sample45) {
			for(int i = 1; i < samples; i += 1)
				st[i] = DistributionSampling.sampleCategorical(RNG$, m[st[(i - 1)]]);
		}
	}

	// Method to execute the model code conventionally, excluding the elements that generate
	// observed values. Distributions are collapsed to single values.
	@Override
	public final void forwardGenerationValuesNoOutputs() {
		// Constraints moved from conditionals in inner loops/scopes/etc.
		if(!fixedFlag$sample17)
			//  Outer loop for dispatching multiple batches of iterations to execute in parallel
			parallelFor(RNG$, 0, states, 1,
				(int forStart$var15, int forEnd$var15, int threadID$var15, org.sandwood.random.internal.Rng RNG$1) -> { 
					
						// Inner loop for running batches of iterations, each batch has its own random number
						// generator.
						for(int var15 = forStart$var15; var15 < forEnd$var15; var15 += 1)
							DistributionSampling.sampleDirichlet(RNG$1, v, m[var15]);
				}
			);

		
		// Constraints moved from conditionals in inner loops/scopes/etc.
		if(!fixedFlag$sample26)
			//  Outer loop for dispatching multiple batches of iterations to execute in parallel
			parallelFor(RNG$, 0, states, 1,
				(int forStart$var24, int forEnd$var24, int threadID$var24, org.sandwood.random.internal.Rng RNG$1) -> { 
					
						// Inner loop for running batches of iterations, each batch has its own random number
						// generator.
						for(int var24 = forStart$var24; var24 < forEnd$var24; var24 += 1)
							bias[var24] = DistributionSampling.sampleBeta(RNG$1, 1.0, 1.0);
				}
			);

		if(!fixedFlag$sample35)
			st[0] = DistributionSampling.sampleCategorical(RNG$, m[0]);
		
		// Constraints moved from conditionals in inner loops/scopes/etc.
		if(!fixedFlag$sample45) {
			for(int i = 1; i < samples; i += 1)
				st[i] = DistributionSampling.sampleCategorical(RNG$, m[st[(i - 1)]]);
		}
	}

	// Method to execute one round of Gibbs sampling.
	@Override
	public final void gibbsRound() {
		// Infer the samples in chronological order.
		if(system$gibbsForward) {
			// Constraints moved from conditionals in inner loops/scopes/etc.
			if(!fixedFlag$sample17)
				//  Outer loop for dispatching multiple batches of iterations to execute in parallel
				parallelFor(RNG$, 0, states, 1,
					(int forStart$var15, int forEnd$var15, int threadID$var15, org.sandwood.random.internal.Rng RNG$1) -> { 
						
							// Inner loop for running batches of iterations, each batch has its own random number
							// generator.
							for(int var15 = forStart$var15; var15 < forEnd$var15; var15 += 1)
								sample17(var15, threadID$var15, RNG$1);
					}
				);

			
			// Constraints moved from conditionals in inner loops/scopes/etc.
			if(!fixedFlag$sample26)
				//  Outer loop for dispatching multiple batches of iterations to execute in parallel
				parallelFor(RNG$, 0, states, 1,
					(int forStart$var24, int forEnd$var24, int threadID$var24, org.sandwood.random.internal.Rng RNG$1) -> { 
						
							// Inner loop for running batches of iterations, each batch has its own random number
							// generator.
							for(int var24 = forStart$var24; var24 < forEnd$var24; var24 += 1)
								sample26(var24, threadID$var24, RNG$1);
					}
				);

			if(!fixedFlag$sample35)
				sample35();
			
			// Constraints moved from conditionals in inner loops/scopes/etc.
			if(!fixedFlag$sample45) {
				for(int i = 1; i < samples; i += 1)
					sample45(i);
			}
		}
		// Infer the samples in reverse chronological order.
		else {
			// Constraints moved from conditionals in inner loops/scopes/etc.
			if(!fixedFlag$sample45) {
				for(int i = (samples - 1); i >= 1; i -= 1)
					sample45(i);
			}
			if(!fixedFlag$sample35)
				sample35();
			
			// Constraints moved from conditionals in inner loops/scopes/etc.
			if(!fixedFlag$sample26)
				//  Outer loop for dispatching multiple batches of iterations to execute in parallel
				parallelFor(RNG$, 0, states, 1,
					(int forStart$var24, int forEnd$var24, int threadID$var24, org.sandwood.random.internal.Rng RNG$1) -> { 
						
							// Inner loop for running batches of iterations, each batch has its own random number
							// generator.
							for(int var24 = forStart$var24; var24 < forEnd$var24; var24 += 1)
								sample26(var24, threadID$var24, RNG$1);
					}
				);

			
			// Constraints moved from conditionals in inner loops/scopes/etc.
			if(!fixedFlag$sample17)
				//  Outer loop for dispatching multiple batches of iterations to execute in parallel
				parallelFor(RNG$, 0, states, 1,
					(int forStart$var15, int forEnd$var15, int threadID$var15, org.sandwood.random.internal.Rng RNG$1) -> { 
						
							// Inner loop for running batches of iterations, each batch has its own random number
							// generator.
							for(int var15 = forStart$var15; var15 < forEnd$var15; var15 += 1)
								sample17(var15, threadID$var15, RNG$1);
					}
				);

		}
		
		// Reverse the direction of execution for the next iteration
		system$gibbsForward = !system$gibbsForward;
	}

	// Method for initialising the model into a valid state before commencing inference
	// etc.
	@Override
	public final void initializeConstants() {
		//  Outer loop for dispatching multiple batches of iterations to execute in parallel
		parallelFor(RNG$, 0, states, 1,
			(int forStart$var8, int forEnd$var8, int threadID$var8, org.sandwood.random.internal.Rng RNG$1) -> { 
				
					// Inner loop for running batches of iterations, each batch has its own random number
					// generator.
					for(int var8 = forStart$var8; var8 < forEnd$var8; var8 += 1)
						v[var8] = 0.1;
			}
		);
		samples = length$measured;
	}

	// A method to initialize all the probabilities in the model to 0/Log(1) ready for
	// the current probabilities to be calculated by calculating the probability of each
	// sample task, and its effect on the rest of the model.
	private final void initializeLogProbabilityFields() {
		// Set the probabilities of the random variable, and the model as a whole to ready
		// them to be reconstructed by the probability calls for each sample. Sample probabilities
		// are only reset for samples that are not fixed at a value that has already been
		// calculated.
		logProbability$$model = 0.0;
		logProbability$$evidence = 0.0;
		logProbability$var11 = 0.0;
		logProbability$m = 0.0;
		if(!fixedProbFlag$sample17)
			logProbability$var16 = 0.0;
		logProbability$var20 = 0.0;
		logProbability$bias = 0.0;
		if(!fixedProbFlag$sample26)
			logProbability$var25 = 0.0;
		logProbability$var32 = 0.0;
		logProbability$st = 0.0;
		if(!fixedProbFlag$sample35)
			logProbability$var33 = 0.0;
		for(int i = 1; i < samples; i += 1)
			logProbability$var42[(i - 1)] = 0.0;
		if(!fixedProbFlag$sample45) {
			for(int i = 1; i < samples; i += 1)
				logProbability$sample45[(i - 1)] = 0.0;
		}
		for(int j = 0; j < samples; j += 1)
			logProbability$var51[j] = 0.0;
		logProbability$flips = 0.0;
		if(!fixedProbFlag$sample54) {
			for(int j = 0; j < samples; j += 1)
				logProbability$sample54[j] = 0.0;
		}
	}

	// Method to generate a new random state for the model excluding any fixed values
	// and then calculate its probability.
	@Override
	public final void logEvidenceGeneration() {
		// Generate values for all the samples in the model that were not fixed or observed.
		forwardGenerationValuesNoOutputs();
		
		// Calculate the probability for the resulting model.
		logEvidenceProbabilities();
	}

	// Construct the evidence probabilities.
	private final void logEvidenceProbabilities() {
		// Reset all the non-fixed probabilities ready to calculate the new values.
		initializeLogProbabilityFields();
		
		// Call each method in turn to generate the new probability values.
		if(fixedFlag$sample17)
			logProbabilityValue$sample17();
		if(fixedFlag$sample26)
			logProbabilityValue$sample26();
		if(fixedFlag$sample35)
			logProbabilityValue$sample35();
		if(fixedFlag$sample45)
			logProbabilityValue$sample45();
		logProbabilityValue$sample54();
	}

	// Method to calculate the probabilities of all the samples in the model including
	// those generating fixed data. In the process probabilities for all the random variables
	// and for the model as a whole will be calculated. This model uses distributions
	// when possible.
	@Override
	public final void logModelProbabilitiesDist() {
		// Reset all the non-fixed probabilities ready to calculate the new values.
		initializeLogProbabilityFields();
		
		// Calculate the probabilities for each sample task in the model, generating probabilities
		// for the random variables and whole model in the process using distributions where
		// appropriate.
		// 
		// Calculate the probabilities for each sample task in the model, generating probabilities
		// for the random variables and whole model in the process using values only.
		logProbabilityValue$sample17();
		logProbabilityValue$sample26();
		logProbabilityValue$sample35();
		logProbabilityValue$sample45();
		logProbabilityValue$sample54();
	}

	// Method to calculate the probabilities of all the samples in the model including
	// those generating fixed data. In the process probabilities for all the random variables
	// and for the model as a whole will be calculated. This model only uses values.
	@Override
	public final void logModelProbabilitiesVal() {
		// Reset all the non-fixed probabilities ready to calculate the new values.
		initializeLogProbabilityFields();
		
		// Calculate the probabilities for each sample task in the model, generating probabilities
		// for the random variables and whole model in the process using distributions where
		// appropriate.
		// 
		// Calculate the probabilities for each sample task in the model, generating probabilities
		// for the random variables and whole model in the process using values only.
		logProbabilityValue$sample17();
		logProbabilityValue$sample26();
		logProbabilityValue$sample35();
		logProbabilityValue$sample45();
		logProbabilityValue$sample54();
	}

	// Method to generate a random state of the model including random outputs, and then
	// to calculate the probability of this random state.
	@Override
	public final void logProbabilityGeneration() {
		// Generate sample values for every call to sample in the model.
		// Constraints moved from conditionals in inner loops/scopes/etc.
		if(!fixedFlag$sample17)
			//  Outer loop for dispatching multiple batches of iterations to execute in parallel
			parallelFor(RNG$, 0, states, 1,
				(int forStart$var15, int forEnd$var15, int threadID$var15, org.sandwood.random.internal.Rng RNG$1) -> { 
					
						// Inner loop for running batches of iterations, each batch has its own random number
						// generator.
						for(int var15 = forStart$var15; var15 < forEnd$var15; var15 += 1)
							DistributionSampling.sampleDirichlet(RNG$1, v, m[var15]);
				}
			);

		
		// Constraints moved from conditionals in inner loops/scopes/etc.
		if(!fixedFlag$sample26)
			//  Outer loop for dispatching multiple batches of iterations to execute in parallel
			parallelFor(RNG$, 0, states, 1,
				(int forStart$var24, int forEnd$var24, int threadID$var24, org.sandwood.random.internal.Rng RNG$1) -> { 
					
						// Inner loop for running batches of iterations, each batch has its own random number
						// generator.
						for(int var24 = forStart$var24; var24 < forEnd$var24; var24 += 1)
							bias[var24] = DistributionSampling.sampleBeta(RNG$1, 1.0, 1.0);
				}
			);

		if(!fixedFlag$sample35)
			st[0] = DistributionSampling.sampleCategorical(RNG$, m[0]);
		
		// Constraints moved from conditionals in inner loops/scopes/etc.
		if(!fixedFlag$sample45) {
			for(int i = 1; i < samples; i += 1)
				st[i] = DistributionSampling.sampleCategorical(RNG$, m[st[(i - 1)]]);
		}
		
		// Calculate the probabilities for every sample task in the model. These values are
		// then used to calculate the probabilities of random variables and the model as a
		// whole.
		logModelProbabilitiesVal();
	}

	// Method to propagate observed values back into the model.
	@Override
	public final void propogateObservedValues() {
		// Propagating values back from observations into the models intermediate variables.
		// 
		// Deep copy between arrays
		int cv$length1 = flips.length;
		for(int cv$index1 = 0; cv$index1 < cv$length1; cv$index1 += 1)
			flips[cv$index1] = measured[cv$index1];
	}

	// A method to set array values that depend on the output of a sample task, but are
	// not directly set by the sample task.
	@Override
	public final void setIntermediates() {}

	@Override
	public String modelCode() {
		return "/*\n * Sandwood\n *\n * Copyright (c) 2019-2023, Oracle and/or its affiliates\n * \n * Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl/\n */\n\npackage org.sandwood.compiler.tests.parser;\n\nmodel HMM(boolean[] measured, int states) {\n\n  double[] v = new double[states] <~ 0.1;\n  double[][] m = dirichlet(v).sample(states);\n    \n  double[] bias = beta(1.0, 1.0).sample(states);\n\n  int samples = measured.length;\n  int[] st = new int[samples];\n        \n  st[0] = categorical(m[0]).sample();\n \n  for(int i:[1..samples))\n    st[i] = categorical(m[st[i - 1]]).sample();\n\n  boolean[] flips = new boolean[samples];\n  for(int j:[0..samples))\n    flips[j] = bernoulli(bias[st[j]]).sample();\n\n  flips.observe(measured);\n}";
	}
}