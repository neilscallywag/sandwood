package org.sandwood.compiler.tests.parser;

import org.sandwood.runtime.internal.numericTools.Conjugates;
import org.sandwood.runtime.internal.numericTools.DistributionSampling;
import org.sandwood.runtime.model.ExecutionTarget;

class HMMTestPart3d$SingleThreadCPU extends org.sandwood.runtime.internal.model.CoreModelSingleThreadCPU implements HMMTestPart3d$CoreInterface {
	private double[] bias;
	private double[] cv$var16$countGlobal;
	private double[] cv$var34$stateProbabilityGlobal;
	private double[] cv$var50$stateProbabilityGlobal;
	private boolean fixedFlag$sample17 = false;
	private boolean fixedFlag$sample26 = false;
	private boolean fixedFlag$sample36 = false;
	private boolean fixedFlag$sample52 = false;
	private boolean fixedFlag$sample79 = false;
	private boolean fixedProbFlag$sample17 = false;
	private boolean fixedProbFlag$sample26 = false;
	private boolean fixedProbFlag$sample36 = false;
	private boolean fixedProbFlag$sample52 = false;
	private boolean fixedProbFlag$sample79 = false;
	private boolean[] flips;
	private boolean[] flipsMeasured;
	private int[][] indirection;
	private int length$flipsMeasured;
	private double logProbability$$evidence;
	private double logProbability$$model;
	private double logProbability$bias;
	private double logProbability$flips;
	private double logProbability$m;
	private double[] logProbability$sample52;
	private double[] logProbability$sample79;
	private double logProbability$st;
	private double logProbability$st2;
	private double logProbability$var11;
	private double logProbability$var16;
	private double logProbability$var20;
	private double logProbability$var25;
	private double logProbability$var33;
	private double logProbability$var34;
	private double[] logProbability$var49;
	private double[] logProbability$var76;
	private double[][] m;
	private int samples;
	private boolean setFlag$bias = false;
	private boolean setFlag$flips = false;
	private boolean setFlag$m = false;
	private boolean setFlag$st = false;
	private boolean setFlag$st2 = false;
	private int[] st;
	private int[] st2;
	private boolean system$gibbsForward = true;
	private double[] v;

	public HMMTestPart3d$SingleThreadCPU(ExecutionTarget target) {
		super(target);
	}

	@Override
	public final double[] get$bias() {
		return bias;
	}

	@Override
	public final void set$bias(double[] cv$value) {
		bias = cv$value;
		setFlag$bias = true;
	}

	@Override
	public final boolean get$fixedFlag$sample17() {
		return fixedFlag$sample17;
	}

	@Override
	public final void set$fixedFlag$sample17(boolean cv$value) {
		fixedFlag$sample17 = cv$value;
		fixedProbFlag$sample17 = (cv$value && fixedProbFlag$sample17);
		fixedProbFlag$sample36 = (cv$value && fixedProbFlag$sample36);
		fixedProbFlag$sample52 = (cv$value && fixedProbFlag$sample52);
	}

	@Override
	public final boolean get$fixedFlag$sample26() {
		return fixedFlag$sample26;
	}

	@Override
	public final void set$fixedFlag$sample26(boolean cv$value) {
		fixedFlag$sample26 = cv$value;
		fixedProbFlag$sample26 = (cv$value && fixedProbFlag$sample26);
		fixedProbFlag$sample79 = (cv$value && fixedProbFlag$sample79);
	}

	@Override
	public final boolean get$fixedFlag$sample36() {
		return fixedFlag$sample36;
	}

	@Override
	public final void set$fixedFlag$sample36(boolean cv$value) {
		fixedFlag$sample36 = cv$value;
		fixedProbFlag$sample36 = (cv$value && fixedProbFlag$sample36);
		fixedProbFlag$sample52 = (cv$value && fixedProbFlag$sample52);
		fixedProbFlag$sample79 = (cv$value && fixedProbFlag$sample79);
	}

	@Override
	public final boolean get$fixedFlag$sample52() {
		return fixedFlag$sample52;
	}

	@Override
	public final void set$fixedFlag$sample52(boolean cv$value) {
		fixedFlag$sample52 = cv$value;
		fixedProbFlag$sample52 = (cv$value && fixedProbFlag$sample52);
		fixedProbFlag$sample79 = (cv$value && fixedProbFlag$sample79);
	}

	@Override
	public final boolean get$fixedFlag$sample79() {
		return fixedFlag$sample79;
	}

	@Override
	public final void set$fixedFlag$sample79(boolean cv$value) {
		fixedFlag$sample79 = cv$value;
		fixedProbFlag$sample79 = (cv$value && fixedProbFlag$sample79);
	}

	@Override
	public final boolean[] get$flips() {
		return flips;
	}

	@Override
	public final void set$flips(boolean[] cv$value) {
		flips = cv$value;
		setFlag$flips = true;
	}

	@Override
	public final boolean[] get$flipsMeasured() {
		return flipsMeasured;
	}

	@Override
	public final void set$flipsMeasured(boolean[] cv$value) {
		flipsMeasured = cv$value;
	}

	@Override
	public final int get$length$flipsMeasured() {
		return length$flipsMeasured;
	}

	@Override
	public final void set$length$flipsMeasured(int cv$value) {
		length$flipsMeasured = cv$value;
	}

	@Override
	public final double get$logProbability$$evidence() {
		return logProbability$$evidence;
	}

	@Override
	public final double getCurrentLogProbability() {
		return logProbability$$model;
	}

	@Override
	public final double get$logProbability$bias() {
		return logProbability$bias;
	}

	@Override
	public final double get$logProbability$flips() {
		return logProbability$flips;
	}

	@Override
	public final double get$logProbability$m() {
		return logProbability$m;
	}

	@Override
	public final double get$logProbability$st() {
		return logProbability$st;
	}

	@Override
	public final double get$logProbability$st2() {
		return logProbability$st2;
	}

	@Override
	public final double[][] get$m() {
		return m;
	}

	@Override
	public final void set$m(double[][] cv$value) {
		m = cv$value;
		setFlag$m = true;
	}

	@Override
	public final int get$samples() {
		return samples;
	}

	@Override
	public final int[] get$st() {
		return st;
	}

	@Override
	public final void set$st(int[] cv$value) {
		st = cv$value;
		setFlag$st = true;
	}

	@Override
	public final int[] get$st2() {
		return st2;
	}

	@Override
	public final void set$st2(int[] cv$value) {
		st2 = cv$value;
		setFlag$st2 = true;
	}

	@Override
	public final int get$states() {
		return 2;
	}

	@Override
	public final double[] get$v() {
		return v;
	}

	private final void logProbabilityValue$sample17() {
		if(!fixedProbFlag$sample17) {
			double cv$sampleAccumulator = (DistributionSampling.logProbabilityDirichlet(m[0], v) + DistributionSampling.logProbabilityDirichlet(m[1], v));
			logProbability$var11 = cv$sampleAccumulator;
			logProbability$var16 = cv$sampleAccumulator;
			logProbability$m = (logProbability$m + cv$sampleAccumulator);
			logProbability$$model = (logProbability$$model + cv$sampleAccumulator);
			if(fixedFlag$sample17)
				logProbability$$evidence = (logProbability$$evidence + cv$sampleAccumulator);
			fixedProbFlag$sample17 = fixedFlag$sample17;
		} else {
			logProbability$var11 = logProbability$var16;
			logProbability$m = (logProbability$m + logProbability$var16);
			logProbability$$model = (logProbability$$model + logProbability$var16);
			if(fixedFlag$sample17)
				logProbability$$evidence = (logProbability$$evidence + logProbability$var16);
		}
	}

	private final void logProbabilityValue$sample26() {
		if(!fixedProbFlag$sample26) {
			double cv$sampleAccumulator = (DistributionSampling.logProbabilityBeta(bias[0], 1.0, 1.0) + DistributionSampling.logProbabilityBeta(bias[1], 1.0, 1.0));
			logProbability$var20 = cv$sampleAccumulator;
			logProbability$var25 = cv$sampleAccumulator;
			logProbability$bias = (logProbability$bias + cv$sampleAccumulator);
			logProbability$$model = (logProbability$$model + cv$sampleAccumulator);
			if(fixedFlag$sample26)
				logProbability$$evidence = (logProbability$$evidence + cv$sampleAccumulator);
			fixedProbFlag$sample26 = fixedFlag$sample26;
		} else {
			logProbability$var20 = logProbability$var25;
			logProbability$bias = (logProbability$bias + logProbability$var25);
			logProbability$$model = (logProbability$$model + logProbability$var25);
			if(fixedFlag$sample26)
				logProbability$$evidence = (logProbability$$evidence + logProbability$var25);
		}
	}

	private final void logProbabilityValue$sample36() {
		if(!fixedProbFlag$sample36) {
			double cv$distributionAccumulator = DistributionSampling.logProbabilityCategorical(st[0], m[0]);
			logProbability$var33 = cv$distributionAccumulator;
			logProbability$var34 = cv$distributionAccumulator;
			logProbability$st = (logProbability$st + cv$distributionAccumulator);
			boolean cv$guard$st2 = true;
			logProbability$st2 = (logProbability$st2 + cv$distributionAccumulator);
			for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
				if(((0 == (indirection[(i$var43 - 1)][i$var43] / i$var43)) && !cv$guard$st2)) {
					cv$guard$st2 = true;
					logProbability$st2 = (logProbability$st2 + cv$distributionAccumulator);
				}
			}
			logProbability$$model = (logProbability$$model + cv$distributionAccumulator);
			if(fixedFlag$sample36)
				logProbability$$evidence = (logProbability$$evidence + cv$distributionAccumulator);
			fixedProbFlag$sample36 = (fixedFlag$sample36 && fixedFlag$sample17);
		} else {
			logProbability$var33 = logProbability$var34;
			logProbability$st = (logProbability$st + logProbability$var34);
			boolean cv$guard$st2 = true;
			logProbability$st2 = (logProbability$st2 + logProbability$var34);
			for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
				if(((0 == (indirection[(i$var43 - 1)][i$var43] / i$var43)) && !cv$guard$st2)) {
					cv$guard$st2 = true;
					logProbability$st2 = (logProbability$st2 + logProbability$var34);
				}
			}
			logProbability$$model = (logProbability$$model + logProbability$var34);
			if(fixedFlag$sample36)
				logProbability$$evidence = (logProbability$$evidence + logProbability$var34);
		}
	}

	private final void logProbabilityValue$sample52() {
		if(!fixedProbFlag$sample52) {
			double cv$accumulator = 0.0;
			for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
				double cv$distributionAccumulator = DistributionSampling.logProbabilityCategorical(st[i$var43], m[(samples - st2[(i$var43 - 1)])]);
				cv$accumulator = (cv$accumulator + cv$distributionAccumulator);
				logProbability$var49[(i$var43 - 1)] = cv$distributionAccumulator;
				logProbability$sample52[(i$var43 - 1)] = cv$distributionAccumulator;
				boolean cv$guard$st2 = false;
				for(int index$i$2_1 = 1; index$i$2_1 < samples; index$i$2_1 += 1) {
					if(((i$var43 == (indirection[(index$i$2_1 - 1)][index$i$2_1] / index$i$2_1)) && !cv$guard$st2)) {
						cv$guard$st2 = true;
						logProbability$st2 = (logProbability$st2 + cv$distributionAccumulator);
					}
				}
			}
			logProbability$st = (logProbability$st + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			if(fixedFlag$sample52)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			fixedProbFlag$sample52 = ((fixedFlag$sample52 && fixedFlag$sample17) && fixedFlag$sample36);
		} else {
			double cv$accumulator = 0.0;
			for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
				double cv$sampleValue = logProbability$sample52[(i$var43 - 1)];
				cv$accumulator = (cv$accumulator + cv$sampleValue);
				logProbability$var49[(i$var43 - 1)] = cv$sampleValue;
				boolean cv$guard$st2 = false;
				for(int index$i$3_1 = 1; index$i$3_1 < samples; index$i$3_1 += 1) {
					if(((i$var43 == (indirection[(index$i$3_1 - 1)][index$i$3_1] / index$i$3_1)) && !cv$guard$st2)) {
						cv$guard$st2 = true;
						logProbability$st2 = (logProbability$st2 + cv$sampleValue);
					}
				}
			}
			logProbability$st = (logProbability$st + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			if(fixedFlag$sample52)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityValue$sample79() {
		if(!fixedProbFlag$sample79) {
			double cv$accumulator = 0.0;
			for(int j = 0; j < samples; j += 1) {
				double cv$distributionAccumulator = DistributionSampling.logProbabilityBernoulli(flips[j], bias[(samples - st2[j])]);
				cv$accumulator = (cv$accumulator + cv$distributionAccumulator);
				logProbability$var76[j] = cv$distributionAccumulator;
				logProbability$sample79[j] = cv$distributionAccumulator;
			}
			logProbability$flips = (logProbability$flips + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			fixedProbFlag$sample79 = (((fixedFlag$sample79 && fixedFlag$sample26) && fixedFlag$sample36) && fixedFlag$sample52);
		} else {
			double cv$accumulator = 0.0;
			for(int j = 0; j < samples; j += 1) {
				double cv$rvAccumulator = logProbability$sample79[j];
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var76[j] = cv$rvAccumulator;
			}
			logProbability$flips = (logProbability$flips + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void sample17(int var15) {
		cv$var16$countGlobal[0] = 0.0;
		cv$var16$countGlobal[1] = 0.0;
		if((var15 == 0))
			cv$var16$countGlobal[st[0]] = (cv$var16$countGlobal[st[0]] + 1.0);
		for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
			if((var15 == (samples - st2[(i$var43 - 1)])))
				cv$var16$countGlobal[st[i$var43]] = (cv$var16$countGlobal[st[i$var43]] + 1.0);
		}
		Conjugates.sampleConjugateDirichletCategorical(RNG$, v, cv$var16$countGlobal, m[var15]);
	}

	private final void sample26(int var24) {
		int cv$sum = 0;
		int cv$count = 0;
		for(int j = 0; j < samples; j += 1) {
			if((var24 == (samples - st2[j]))) {
				cv$count = (cv$count + 1);
				if(flips[j])
					cv$sum = (cv$sum + 1);
			}
		}
		bias[var24] = Conjugates.sampleConjugateBetaBinomial(RNG$, 1.0, 1.0, cv$sum, cv$count);
	}

	private final void sample36() {
		{
			st[0] = 0;
			for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
				if((0 == (indirection[(i$var43 - 1)][i$var43] / i$var43)))
					st2[(indirection[(i$var43 - 1)][i$var43] / i$var43)] = (samples - st[(indirection[(i$var43 - 1)][i$var43] / i$var43)]);
			}
			double cv$accumulatedProbabilities = DistributionSampling.logProbabilityCategorical(0, m[0]);
			if((1 < samples))
				cv$accumulatedProbabilities = (DistributionSampling.logProbabilityCategorical(st[1], m[0]) + cv$accumulatedProbabilities);
			for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
				if((0 == (indirection[(i$var43 - 1)][i$var43] / i$var43))) {
					int index$i$4_4 = ((indirection[(i$var43 - 1)][i$var43] / i$var43) + 1);
					if(((1 <= index$i$4_4) && (index$i$4_4 < samples)))
						cv$accumulatedProbabilities = (DistributionSampling.logProbabilityCategorical(st[index$i$4_4], m[0]) + cv$accumulatedProbabilities);
				}
			}
			if((0 < samples))
				cv$accumulatedProbabilities = (DistributionSampling.logProbabilityBernoulli(flips[0], bias[0]) + cv$accumulatedProbabilities);
			for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
				if((0 == (indirection[(i$var43 - 1)][i$var43] / i$var43))) {
					int j = (indirection[(i$var43 - 1)][i$var43] / i$var43);
					if(((0 <= j) && (j < samples)))
						cv$accumulatedProbabilities = (DistributionSampling.logProbabilityBernoulli(flips[j], bias[0]) + cv$accumulatedProbabilities);
				}
			}
			cv$var34$stateProbabilityGlobal[0] = cv$accumulatedProbabilities;
		}
		st[0] = 1;
		for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
			if((0 == (indirection[(i$var43 - 1)][i$var43] / i$var43)))
				st2[(indirection[(i$var43 - 1)][i$var43] / i$var43)] = (samples - st[(indirection[(i$var43 - 1)][i$var43] / i$var43)]);
		}
		double cv$accumulatedProbabilities = DistributionSampling.logProbabilityCategorical(1, m[0]);
		if((1 < samples))
			cv$accumulatedProbabilities = (DistributionSampling.logProbabilityCategorical(st[1], m[1]) + cv$accumulatedProbabilities);
		for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
			if((0 == (indirection[(i$var43 - 1)][i$var43] / i$var43))) {
				int index$i$4_4 = ((indirection[(i$var43 - 1)][i$var43] / i$var43) + 1);
				if(((1 <= index$i$4_4) && (index$i$4_4 < samples)))
					cv$accumulatedProbabilities = (DistributionSampling.logProbabilityCategorical(st[index$i$4_4], m[1]) + cv$accumulatedProbabilities);
			}
		}
		if((0 < samples))
			cv$accumulatedProbabilities = (DistributionSampling.logProbabilityBernoulli(flips[0], bias[1]) + cv$accumulatedProbabilities);
		for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
			if((0 == (indirection[(i$var43 - 1)][i$var43] / i$var43))) {
				int j = (indirection[(i$var43 - 1)][i$var43] / i$var43);
				if(((0 <= j) && (j < samples)))
					cv$accumulatedProbabilities = (DistributionSampling.logProbabilityBernoulli(flips[j], bias[1]) + cv$accumulatedProbabilities);
			}
		}
		cv$var34$stateProbabilityGlobal[1] = cv$accumulatedProbabilities;
		double cv$logSum;
		double cv$lseMax = cv$var34$stateProbabilityGlobal[0];
		for(int cv$lseIndex = 1; cv$lseIndex < cv$var34$stateProbabilityGlobal.length; cv$lseIndex += 1) {
			double cv$lseElementValue = cv$var34$stateProbabilityGlobal[cv$lseIndex];
			if((cv$lseMax < cv$lseElementValue))
				cv$lseMax = cv$lseElementValue;
		}
		if((cv$lseMax == Double.NEGATIVE_INFINITY))
			cv$logSum = Double.NEGATIVE_INFINITY;
		else {
			double cv$lseSum = 0.0;
			for(int cv$lseIndex = 0; cv$lseIndex < cv$var34$stateProbabilityGlobal.length; cv$lseIndex += 1)
				cv$lseSum = (cv$lseSum + Math.exp((cv$var34$stateProbabilityGlobal[cv$lseIndex] - cv$lseMax)));
			cv$logSum = (Math.log(cv$lseSum) + cv$lseMax);
		}
		if((cv$logSum == Double.NEGATIVE_INFINITY)) {
			for(int cv$indexName = 0; cv$indexName < cv$var34$stateProbabilityGlobal.length; cv$indexName += 1)
				cv$var34$stateProbabilityGlobal[cv$indexName] = (1.0 / cv$var34$stateProbabilityGlobal.length);
		} else {
			for(int cv$indexName = 0; cv$indexName < cv$var34$stateProbabilityGlobal.length; cv$indexName += 1)
				cv$var34$stateProbabilityGlobal[cv$indexName] = Math.exp((cv$var34$stateProbabilityGlobal[cv$indexName] - cv$logSum));
		}
		st[0] = DistributionSampling.sampleCategorical(RNG$, cv$var34$stateProbabilityGlobal);
		st2[0] = (samples - st[0]);
		for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
			if((0 == (indirection[(i$var43 - 1)][i$var43] / i$var43)))
				st2[(indirection[(i$var43 - 1)][i$var43] / i$var43)] = (samples - st[(indirection[(i$var43 - 1)][i$var43] / i$var43)]);
		}
	}

	private final void sample52(int i$var43) {
		{
			st[i$var43] = 0;
			for(int index$i$1_1 = 1; index$i$1_1 < samples; index$i$1_1 += 1) {
				if((i$var43 == (indirection[(index$i$1_1 - 1)][index$i$1_1] / index$i$1_1)))
					st2[(indirection[(index$i$1_1 - 1)][index$i$1_1] / index$i$1_1)] = (samples - st[(indirection[(index$i$1_1 - 1)][index$i$1_1] / index$i$1_1)]);
			}
			double cv$accumulatedProbabilities = DistributionSampling.logProbabilityCategorical(0, m[(samples - st2[(i$var43 - 1)])]);
			for(int index$i$2_2 = 1; index$i$2_2 < samples; index$i$2_2 += 1) {
				if((i$var43 == (indirection[(index$i$2_2 - 1)][index$i$2_2] / index$i$2_2))) {
					int index$i$2_4 = ((indirection[(index$i$2_2 - 1)][index$i$2_2] / index$i$2_2) + 1);
					if(((1 <= index$i$2_4) && (index$i$2_4 < samples)))
						cv$accumulatedProbabilities = (DistributionSampling.logProbabilityCategorical(st[index$i$2_4], m[0]) + cv$accumulatedProbabilities);
				}
			}
			for(int index$i$5_2 = 1; index$i$5_2 < samples; index$i$5_2 += 1) {
				if((i$var43 == (indirection[(index$i$5_2 - 1)][index$i$5_2] / index$i$5_2))) {
					int j = (indirection[(index$i$5_2 - 1)][index$i$5_2] / index$i$5_2);
					if(((0 <= j) && (j < samples)))
						cv$accumulatedProbabilities = (DistributionSampling.logProbabilityBernoulli(flips[j], bias[0]) + cv$accumulatedProbabilities);
				}
			}
			cv$var50$stateProbabilityGlobal[0] = cv$accumulatedProbabilities;
		}
		st[i$var43] = 1;
		for(int index$i$1_1 = 1; index$i$1_1 < samples; index$i$1_1 += 1) {
			if((i$var43 == (indirection[(index$i$1_1 - 1)][index$i$1_1] / index$i$1_1)))
				st2[(indirection[(index$i$1_1 - 1)][index$i$1_1] / index$i$1_1)] = (samples - st[(indirection[(index$i$1_1 - 1)][index$i$1_1] / index$i$1_1)]);
		}
		double cv$accumulatedProbabilities = DistributionSampling.logProbabilityCategorical(1, m[(samples - st2[(i$var43 - 1)])]);
		for(int index$i$2_2 = 1; index$i$2_2 < samples; index$i$2_2 += 1) {
			if((i$var43 == (indirection[(index$i$2_2 - 1)][index$i$2_2] / index$i$2_2))) {
				int index$i$2_4 = ((indirection[(index$i$2_2 - 1)][index$i$2_2] / index$i$2_2) + 1);
				if(((1 <= index$i$2_4) && (index$i$2_4 < samples)))
					cv$accumulatedProbabilities = (DistributionSampling.logProbabilityCategorical(st[index$i$2_4], m[1]) + cv$accumulatedProbabilities);
			}
		}
		for(int index$i$5_2 = 1; index$i$5_2 < samples; index$i$5_2 += 1) {
			if((i$var43 == (indirection[(index$i$5_2 - 1)][index$i$5_2] / index$i$5_2))) {
				int j = (indirection[(index$i$5_2 - 1)][index$i$5_2] / index$i$5_2);
				if(((0 <= j) && (j < samples)))
					cv$accumulatedProbabilities = (DistributionSampling.logProbabilityBernoulli(flips[j], bias[1]) + cv$accumulatedProbabilities);
			}
		}
		cv$var50$stateProbabilityGlobal[1] = cv$accumulatedProbabilities;
		double cv$logSum;
		double cv$lseMax = cv$var50$stateProbabilityGlobal[0];
		for(int cv$lseIndex = 1; cv$lseIndex < cv$var50$stateProbabilityGlobal.length; cv$lseIndex += 1) {
			double cv$lseElementValue = cv$var50$stateProbabilityGlobal[cv$lseIndex];
			if((cv$lseMax < cv$lseElementValue))
				cv$lseMax = cv$lseElementValue;
		}
		if((cv$lseMax == Double.NEGATIVE_INFINITY))
			cv$logSum = Double.NEGATIVE_INFINITY;
		else {
			double cv$lseSum = 0.0;
			for(int cv$lseIndex = 0; cv$lseIndex < cv$var50$stateProbabilityGlobal.length; cv$lseIndex += 1)
				cv$lseSum = (cv$lseSum + Math.exp((cv$var50$stateProbabilityGlobal[cv$lseIndex] - cv$lseMax)));
			cv$logSum = (Math.log(cv$lseSum) + cv$lseMax);
		}
		if((cv$logSum == Double.NEGATIVE_INFINITY)) {
			for(int cv$indexName = 0; cv$indexName < cv$var50$stateProbabilityGlobal.length; cv$indexName += 1)
				cv$var50$stateProbabilityGlobal[cv$indexName] = (1.0 / cv$var50$stateProbabilityGlobal.length);
		} else {
			for(int cv$indexName = 0; cv$indexName < cv$var50$stateProbabilityGlobal.length; cv$indexName += 1)
				cv$var50$stateProbabilityGlobal[cv$indexName] = Math.exp((cv$var50$stateProbabilityGlobal[cv$indexName] - cv$logSum));
		}
		st[i$var43] = DistributionSampling.sampleCategorical(RNG$, cv$var50$stateProbabilityGlobal);
		for(int index$i$8_1 = 1; index$i$8_1 < samples; index$i$8_1 += 1) {
			if((i$var43 == (indirection[(index$i$8_1 - 1)][index$i$8_1] / index$i$8_1)))
				st2[(indirection[(index$i$8_1 - 1)][index$i$8_1] / index$i$8_1)] = (samples - st[(indirection[(index$i$8_1 - 1)][index$i$8_1] / index$i$8_1)]);
		}
	}

	@Override
	public final void allocateScratch() {
		cv$var16$countGlobal = new double[2];
		cv$var34$stateProbabilityGlobal = new double[2];
		cv$var50$stateProbabilityGlobal = new double[2];
	}

	@Override
	public final void allocator() {
		v = new double[2];
		if(!setFlag$m) {
			m = new double[2][];
			m[0] = new double[2];
			m[1] = new double[2];
		}
		if(!setFlag$bias)
			bias = new double[2];
		if(!setFlag$st)
			st = new int[length$flipsMeasured];
		if(!setFlag$st2)
			st2 = new int[length$flipsMeasured];
		indirection = new int[(length$flipsMeasured - 1)][];
		for(int i$var43 = 1; i$var43 < length$flipsMeasured; i$var43 += 1)
			indirection[(i$var43 - 1)] = new int[(i$var43 + 1)];
		if(!setFlag$flips)
			flips = new boolean[length$flipsMeasured];
		logProbability$var49 = new double[(length$flipsMeasured - 1)];
		logProbability$sample52 = new double[(length$flipsMeasured - 1)];
		logProbability$var76 = new double[length$flipsMeasured];
		logProbability$sample79 = new double[length$flipsMeasured];
		allocateScratch();
	}

	@Override
	public final void forwardGeneration() {
		if(!fixedFlag$sample17) {
			DistributionSampling.sampleDirichlet(RNG$, v, m[0]);
			DistributionSampling.sampleDirichlet(RNG$, v, m[1]);
		}
		if(!fixedFlag$sample26) {
			bias[0] = DistributionSampling.sampleBeta(RNG$, 1.0, 1.0);
			bias[1] = DistributionSampling.sampleBeta(RNG$, 1.0, 1.0);
		}
		if(!fixedFlag$sample36) {
			st[0] = DistributionSampling.sampleCategorical(RNG$, m[0]);
			st2[0] = (samples - st[0]);
		}
		for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
			if(!fixedFlag$sample52)
				st[i$var43] = DistributionSampling.sampleCategorical(RNG$, m[(samples - st2[(i$var43 - 1)])]);
			if((!fixedFlag$sample36 || !fixedFlag$sample52))
				st2[(indirection[(i$var43 - 1)][i$var43] / i$var43)] = (samples - st[(indirection[(i$var43 - 1)][i$var43] / i$var43)]);
		}
		if(!fixedFlag$sample79) {
			for(int j = 0; j < samples; j += 1)
				flips[j] = DistributionSampling.sampleBernoulli(RNG$, bias[(samples - st2[j])]);
		}
	}

	@Override
	public final void forwardGenerationDistributionsNoOutputs() {
		if(!fixedFlag$sample17) {
			DistributionSampling.sampleDirichlet(RNG$, v, m[0]);
			DistributionSampling.sampleDirichlet(RNG$, v, m[1]);
		}
		if(!fixedFlag$sample26) {
			bias[0] = DistributionSampling.sampleBeta(RNG$, 1.0, 1.0);
			bias[1] = DistributionSampling.sampleBeta(RNG$, 1.0, 1.0);
		}
		if(!fixedFlag$sample36) {
			st[0] = DistributionSampling.sampleCategorical(RNG$, m[0]);
			st2[0] = (samples - st[0]);
		}
		for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
			if(!fixedFlag$sample52)
				st[i$var43] = DistributionSampling.sampleCategorical(RNG$, m[(samples - st2[(i$var43 - 1)])]);
			if((!fixedFlag$sample36 || !fixedFlag$sample52))
				st2[(indirection[(i$var43 - 1)][i$var43] / i$var43)] = (samples - st[(indirection[(i$var43 - 1)][i$var43] / i$var43)]);
		}
	}

	@Override
	public final void forwardGenerationValuesNoOutputs() {
		if(!fixedFlag$sample17) {
			DistributionSampling.sampleDirichlet(RNG$, v, m[0]);
			DistributionSampling.sampleDirichlet(RNG$, v, m[1]);
		}
		if(!fixedFlag$sample26) {
			bias[0] = DistributionSampling.sampleBeta(RNG$, 1.0, 1.0);
			bias[1] = DistributionSampling.sampleBeta(RNG$, 1.0, 1.0);
		}
		if(!fixedFlag$sample36) {
			st[0] = DistributionSampling.sampleCategorical(RNG$, m[0]);
			st2[0] = (samples - st[0]);
		}
		for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
			if(!fixedFlag$sample52)
				st[i$var43] = DistributionSampling.sampleCategorical(RNG$, m[(samples - st2[(i$var43 - 1)])]);
			if((!fixedFlag$sample36 || !fixedFlag$sample52))
				st2[(indirection[(i$var43 - 1)][i$var43] / i$var43)] = (samples - st[(indirection[(i$var43 - 1)][i$var43] / i$var43)]);
		}
	}

	@Override
	public final void gibbsRound() {
		if(system$gibbsForward) {
			if(!fixedFlag$sample17) {
				sample17(0);
				sample17(1);
			}
			if(!fixedFlag$sample26) {
				sample26(0);
				sample26(1);
			}
			if(!fixedFlag$sample36)
				sample36();
			if(!fixedFlag$sample52) {
				for(int i$var43 = 1; i$var43 < samples; i$var43 += 1)
					sample52(i$var43);
			}
		} else {
			if(!fixedFlag$sample52) {
				for(int i$var43 = (samples - 1); i$var43 >= 1; i$var43 -= 1)
					sample52(i$var43);
			}
			if(!fixedFlag$sample36)
				sample36();
			if(!fixedFlag$sample26) {
				sample26(1);
				sample26(0);
			}
			if(!fixedFlag$sample17) {
				sample17(1);
				sample17(0);
			}
		}
		system$gibbsForward = !system$gibbsForward;
	}

	@Override
	public final void initializeConstants() {
		v[0] = 0.1;
		v[1] = 0.1;
		samples = length$flipsMeasured;
		for(int i$var43 = 1; i$var43 < length$flipsMeasured; i$var43 += 1) {
			for(int k = 0; k <= i$var43; k += 1)
				indirection[(i$var43 - 1)][k] = (k * i$var43);
		}
	}

	private final void initializeLogProbabilityFields() {
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
		logProbability$var33 = 0.0;
		logProbability$st = 0.0;
		logProbability$st2 = 0.0;
		if(!fixedProbFlag$sample36)
			logProbability$var34 = 0.0;
		for(int i$var43 = 1; i$var43 < samples; i$var43 += 1)
			logProbability$var49[(i$var43 - 1)] = 0.0;
		if(!fixedProbFlag$sample52) {
			for(int i$var43 = 1; i$var43 < samples; i$var43 += 1)
				logProbability$sample52[(i$var43 - 1)] = 0.0;
		}
		for(int j = 0; j < samples; j += 1)
			logProbability$var76[j] = 0.0;
		logProbability$flips = 0.0;
		if(!fixedProbFlag$sample79) {
			for(int j = 0; j < samples; j += 1)
				logProbability$sample79[j] = 0.0;
		}
	}

	@Override
	public final void logEvidenceGeneration() {
		forwardGenerationValuesNoOutputs();
		logEvidenceProbabilities();
	}

	private final void logEvidenceProbabilities() {
		initializeLogProbabilityFields();
		if(fixedFlag$sample17)
			logProbabilityValue$sample17();
		if(fixedFlag$sample26)
			logProbabilityValue$sample26();
		if(fixedFlag$sample36)
			logProbabilityValue$sample36();
		if(fixedFlag$sample52)
			logProbabilityValue$sample52();
		logProbabilityValue$sample79();
	}

	@Override
	public final void logModelProbabilitiesDist() {
		initializeLogProbabilityFields();
		logProbabilityValue$sample17();
		logProbabilityValue$sample26();
		logProbabilityValue$sample36();
		logProbabilityValue$sample52();
		logProbabilityValue$sample79();
	}

	@Override
	public final void logModelProbabilitiesVal() {
		initializeLogProbabilityFields();
		logProbabilityValue$sample17();
		logProbabilityValue$sample26();
		logProbabilityValue$sample36();
		logProbabilityValue$sample52();
		logProbabilityValue$sample79();
	}

	@Override
	public final void logProbabilityGeneration() {
		if(!fixedFlag$sample17) {
			DistributionSampling.sampleDirichlet(RNG$, v, m[0]);
			DistributionSampling.sampleDirichlet(RNG$, v, m[1]);
		}
		if(!fixedFlag$sample26) {
			bias[0] = DistributionSampling.sampleBeta(RNG$, 1.0, 1.0);
			bias[1] = DistributionSampling.sampleBeta(RNG$, 1.0, 1.0);
		}
		if(!fixedFlag$sample36) {
			st[0] = DistributionSampling.sampleCategorical(RNG$, m[0]);
			st2[0] = (samples - st[0]);
		}
		for(int i$var43 = 1; i$var43 < samples; i$var43 += 1) {
			if(!fixedFlag$sample52)
				st[i$var43] = DistributionSampling.sampleCategorical(RNG$, m[(samples - st2[(i$var43 - 1)])]);
			if((!fixedFlag$sample36 || !fixedFlag$sample52))
				st2[(indirection[(i$var43 - 1)][i$var43] / i$var43)] = (samples - st[(indirection[(i$var43 - 1)][i$var43] / i$var43)]);
		}
		logModelProbabilitiesVal();
	}

	@Override
	public final void propogateObservedValues() {
		int cv$length1 = flips.length;
		for(int cv$index1 = 0; cv$index1 < cv$length1; cv$index1 += 1)
			flips[cv$index1] = flipsMeasured[cv$index1];
	}

	@Override
	public final void setIntermediates() {
		if(setFlag$st) {
			st2[0] = (samples - st[0]);
			for(int i$var43 = 1; i$var43 < samples; i$var43 += 1)
				st2[(indirection[(i$var43 - 1)][i$var43] / i$var43)] = (samples - st[(indirection[(i$var43 - 1)][i$var43] / i$var43)]);
		}
	}

	@Override
	public String modelCode() {
		return "/*\n * Sandwood\n *\n * Copyright (c) 2019-2023, Oracle and/or its affiliates\n * \n * Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl/\n */\n\npackage org.sandwood.compiler.tests.parser;\n\nmodel HMMTestPart3d(boolean[] flipsMeasured) {\n        int states = 2;\n\n        double[] v = new double[states];\n        for(int i:[0..states))\n            v[i] = 0.1;\n\n        double[][] m = dirichlet(v).sample(states);\n        double[] bias = beta(1.0, 1.0).sample(states);\n\n        int samples = flipsMeasured.length;\n        int[] st = new int[samples];\n        int[] st2 = new int[samples];\n\n        st[0] = categorical(m[0]).sample();\n        st2[0] = samples - st[0];\n\n        for(int i:[1..samples)) {\n            st[i] = categorical(m[samples - st2[i-1]]).sample();\n            \n            int[] indirection = new int[i+1];\n            for(int k:[0..i])\n                indirection[k] = k*i; \n                \n            st2[indirection[i]/i] = samples - st[indirection[i]/i];\n        }\n            \n        boolean[] flips = new boolean[samples];\n            \n        for(int j:[0..samples))\n            flips[j] = bernoulli(bias[samples - st2[j]]).sample();\n\n        flips.observe(flipsMeasured);\n}\n";
	}
}