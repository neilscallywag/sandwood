package org.sandwood.compiler.tests.parser;

import org.sandwood.random.internal.Rng;
import org.sandwood.runtime.internal.numericTools.Conjugates;
import org.sandwood.runtime.internal.numericTools.DistributionSampling;
import org.sandwood.runtime.model.ExecutionTarget;

class HMMMetrics$MultiThreadCPU extends org.sandwood.runtime.internal.model.CoreModelMultiThreadCPU implements HMMMetrics$CoreInterface {
	private double[] cpu;
	private double[] cpuMean;
	private double[] cpuVar;
	private double[] cpu_measured;
	private double[] cv$distributionAccumulator$var39;
	private double[][] cv$var22$countGlobal;
	private double[] cv$var27$countGlobal;
	private double[] cv$var30$stateProbabilityGlobal;
	private double[] cv$var40$stateProbabilityGlobal;
	private double[] distribution$sample34;
	private double[][] distribution$sample44;
	private boolean fixedFlag$sample109 = false;
	private boolean fixedFlag$sample118 = false;
	private boolean fixedFlag$sample123 = false;
	private boolean fixedFlag$sample128 = false;
	private boolean fixedFlag$sample25 = false;
	private boolean fixedFlag$sample31 = false;
	private boolean fixedFlag$sample34 = false;
	private boolean fixedFlag$sample44 = false;
	private boolean fixedFlag$sample57 = false;
	private boolean fixedFlag$sample68 = false;
	private boolean fixedFlag$sample79 = false;
	private boolean fixedFlag$sample89 = false;
	private boolean fixedFlag$sample99 = false;
	private boolean fixedProbFlag$sample109 = false;
	private boolean fixedProbFlag$sample118 = false;
	private boolean fixedProbFlag$sample123 = false;
	private boolean fixedProbFlag$sample128 = false;
	private boolean fixedProbFlag$sample25 = false;
	private boolean fixedProbFlag$sample31 = false;
	private boolean fixedProbFlag$sample34 = false;
	private boolean fixedProbFlag$sample44 = false;
	private boolean fixedProbFlag$sample57 = false;
	private boolean fixedProbFlag$sample68 = false;
	private boolean fixedProbFlag$sample79 = false;
	private boolean fixedProbFlag$sample89 = false;
	private boolean fixedProbFlag$sample99 = false;
	private boolean[] guard$sample34gaussian117$global;
	private boolean[] guard$sample34gaussian122$global;
	private boolean[] guard$sample34gaussian127$global;
	private boolean[] guard$sample44gaussian117$global;
	private boolean[] guard$sample44gaussian122$global;
	private boolean[] guard$sample44gaussian127$global;
	private double[] initialStateDistribution;
	private int length$cpu_measured;
	private double logProbability$$evidence;
	private double logProbability$$model;
	private double logProbability$cpu;
	private double logProbability$cpuMean;
	private double logProbability$cpuVar;
	private double logProbability$initialStateDistribution;
	private double logProbability$m;
	private double logProbability$mem;
	private double logProbability$memMean;
	private double logProbability$memVar;
	private double logProbability$pageFaults;
	private double logProbability$pageFaultsMean;
	private double logProbability$pageFaultsVar;
	private double[] logProbability$sample118;
	private double[] logProbability$sample123;
	private double[] logProbability$sample128;
	private double[] logProbability$sample44;
	private double logProbability$st;
	private double logProbability$var100;
	private double logProbability$var105;
	private double[] logProbability$var113;
	private double[] logProbability$var118;
	private double[] logProbability$var123;
	private double logProbability$var17;
	private double logProbability$var22;
	private double logProbability$var26;
	private double logProbability$var29;
	private double logProbability$var30;
	private double[] logProbability$var39;
	private double logProbability$var48;
	private double logProbability$var53;
	private double logProbability$var59;
	private double logProbability$var64;
	private double logProbability$var70;
	private double logProbability$var75;
	private double logProbability$var80;
	private double logProbability$var85;
	private double logProbability$var90;
	private double logProbability$var95;
	private double[][] m;
	private double[] mem;
	private double[] memMean;
	private double[] memVar;
	private double[] mem_measured;
	private int noStates;
	private double[] pageFaults;
	private double[] pageFaultsMean;
	private double[] pageFaultsVar;
	private double[] pageFaults_measured;
	private int samples;
	private boolean setFlag$cpu = false;
	private boolean setFlag$cpuMean = false;
	private boolean setFlag$cpuVar = false;
	private boolean setFlag$initialStateDistribution = false;
	private boolean setFlag$m = false;
	private boolean setFlag$mem = false;
	private boolean setFlag$memMean = false;
	private boolean setFlag$memVar = false;
	private boolean setFlag$pageFaults = false;
	private boolean setFlag$pageFaultsMean = false;
	private boolean setFlag$pageFaultsVar = false;
	private boolean setFlag$st = false;
	private int[] st;
	private boolean system$gibbsForward = true;
	private double[] v;

	public HMMMetrics$MultiThreadCPU(ExecutionTarget target) {
		super(target);
	}

	@Override
	public final double[] get$cpu() {
		return cpu;
	}

	@Override
	public final void set$cpu(double[] cv$value) {
		cpu = cv$value;
		setFlag$cpu = true;
	}

	@Override
	public final double[] get$cpuMean() {
		return cpuMean;
	}

	@Override
	public final void set$cpuMean(double[] cv$value) {
		cpuMean = cv$value;
		setFlag$cpuMean = true;
	}

	@Override
	public final double[] get$cpuVar() {
		return cpuVar;
	}

	@Override
	public final void set$cpuVar(double[] cv$value) {
		cpuVar = cv$value;
		setFlag$cpuVar = true;
	}

	@Override
	public final double[] get$cpu_measured() {
		return cpu_measured;
	}

	@Override
	public final void set$cpu_measured(double[] cv$value) {
		cpu_measured = cv$value;
	}

	@Override
	public final boolean get$fixedFlag$sample109() {
		return fixedFlag$sample109;
	}

	@Override
	public final void set$fixedFlag$sample109(boolean cv$value) {
		fixedFlag$sample109 = cv$value;
		fixedProbFlag$sample109 = (cv$value && fixedProbFlag$sample109);
		fixedProbFlag$sample128 = (cv$value && fixedProbFlag$sample128);
	}

	@Override
	public final boolean get$fixedFlag$sample118() {
		return fixedFlag$sample118;
	}

	@Override
	public final void set$fixedFlag$sample118(boolean cv$value) {
		fixedFlag$sample118 = cv$value;
		fixedProbFlag$sample118 = (cv$value && fixedProbFlag$sample118);
	}

	@Override
	public final boolean get$fixedFlag$sample123() {
		return fixedFlag$sample123;
	}

	@Override
	public final void set$fixedFlag$sample123(boolean cv$value) {
		fixedFlag$sample123 = cv$value;
		fixedProbFlag$sample123 = (cv$value && fixedProbFlag$sample123);
	}

	@Override
	public final boolean get$fixedFlag$sample128() {
		return fixedFlag$sample128;
	}

	@Override
	public final void set$fixedFlag$sample128(boolean cv$value) {
		fixedFlag$sample128 = cv$value;
		fixedProbFlag$sample128 = (cv$value && fixedProbFlag$sample128);
	}

	@Override
	public final boolean get$fixedFlag$sample25() {
		return fixedFlag$sample25;
	}

	@Override
	public final void set$fixedFlag$sample25(boolean cv$value) {
		fixedFlag$sample25 = cv$value;
		fixedProbFlag$sample25 = (cv$value && fixedProbFlag$sample25);
		fixedProbFlag$sample44 = (cv$value && fixedProbFlag$sample44);
	}

	@Override
	public final boolean get$fixedFlag$sample31() {
		return fixedFlag$sample31;
	}

	@Override
	public final void set$fixedFlag$sample31(boolean cv$value) {
		fixedFlag$sample31 = cv$value;
		fixedProbFlag$sample31 = (cv$value && fixedProbFlag$sample31);
		fixedProbFlag$sample34 = (cv$value && fixedProbFlag$sample34);
	}

	@Override
	public final boolean get$fixedFlag$sample34() {
		return fixedFlag$sample34;
	}

	@Override
	public final void set$fixedFlag$sample34(boolean cv$value) {
		fixedFlag$sample34 = cv$value;
		fixedProbFlag$sample34 = (cv$value && fixedProbFlag$sample34);
		fixedProbFlag$sample44 = (cv$value && fixedProbFlag$sample44);
		fixedProbFlag$sample118 = (cv$value && fixedProbFlag$sample118);
		fixedProbFlag$sample123 = (cv$value && fixedProbFlag$sample123);
		fixedProbFlag$sample128 = (cv$value && fixedProbFlag$sample128);
	}

	@Override
	public final boolean get$fixedFlag$sample44() {
		return fixedFlag$sample44;
	}

	@Override
	public final void set$fixedFlag$sample44(boolean cv$value) {
		fixedFlag$sample44 = cv$value;
		fixedProbFlag$sample44 = (cv$value && fixedProbFlag$sample44);
		fixedProbFlag$sample118 = (cv$value && fixedProbFlag$sample118);
		fixedProbFlag$sample123 = (cv$value && fixedProbFlag$sample123);
		fixedProbFlag$sample128 = (cv$value && fixedProbFlag$sample128);
	}

	@Override
	public final boolean get$fixedFlag$sample57() {
		return fixedFlag$sample57;
	}

	@Override
	public final void set$fixedFlag$sample57(boolean cv$value) {
		fixedFlag$sample57 = cv$value;
		fixedProbFlag$sample57 = (cv$value && fixedProbFlag$sample57);
		fixedProbFlag$sample118 = (cv$value && fixedProbFlag$sample118);
	}

	@Override
	public final boolean get$fixedFlag$sample68() {
		return fixedFlag$sample68;
	}

	@Override
	public final void set$fixedFlag$sample68(boolean cv$value) {
		fixedFlag$sample68 = cv$value;
		fixedProbFlag$sample68 = (cv$value && fixedProbFlag$sample68);
		fixedProbFlag$sample123 = (cv$value && fixedProbFlag$sample123);
	}

	@Override
	public final boolean get$fixedFlag$sample79() {
		return fixedFlag$sample79;
	}

	@Override
	public final void set$fixedFlag$sample79(boolean cv$value) {
		fixedFlag$sample79 = cv$value;
		fixedProbFlag$sample79 = (cv$value && fixedProbFlag$sample79);
		fixedProbFlag$sample128 = (cv$value && fixedProbFlag$sample128);
	}

	@Override
	public final boolean get$fixedFlag$sample89() {
		return fixedFlag$sample89;
	}

	@Override
	public final void set$fixedFlag$sample89(boolean cv$value) {
		fixedFlag$sample89 = cv$value;
		fixedProbFlag$sample89 = (cv$value && fixedProbFlag$sample89);
		fixedProbFlag$sample118 = (cv$value && fixedProbFlag$sample118);
	}

	@Override
	public final boolean get$fixedFlag$sample99() {
		return fixedFlag$sample99;
	}

	@Override
	public final void set$fixedFlag$sample99(boolean cv$value) {
		fixedFlag$sample99 = cv$value;
		fixedProbFlag$sample99 = (cv$value && fixedProbFlag$sample99);
		fixedProbFlag$sample123 = (cv$value && fixedProbFlag$sample123);
	}

	@Override
	public final double[] get$initialStateDistribution() {
		return initialStateDistribution;
	}

	@Override
	public final void set$initialStateDistribution(double[] cv$value) {
		initialStateDistribution = cv$value;
		setFlag$initialStateDistribution = true;
	}

	@Override
	public final int get$length$cpu_measured() {
		return length$cpu_measured;
	}

	@Override
	public final void set$length$cpu_measured(int cv$value) {
		length$cpu_measured = cv$value;
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
	public final double get$logProbability$cpu() {
		return logProbability$cpu;
	}

	@Override
	public final double get$logProbability$cpuMean() {
		return logProbability$cpuMean;
	}

	@Override
	public final double get$logProbability$cpuVar() {
		return logProbability$cpuVar;
	}

	@Override
	public final double get$logProbability$initialStateDistribution() {
		return logProbability$initialStateDistribution;
	}

	@Override
	public final double get$logProbability$m() {
		return logProbability$m;
	}

	@Override
	public final double get$logProbability$mem() {
		return logProbability$mem;
	}

	@Override
	public final double get$logProbability$memMean() {
		return logProbability$memMean;
	}

	@Override
	public final double get$logProbability$memVar() {
		return logProbability$memVar;
	}

	@Override
	public final double get$logProbability$pageFaults() {
		return logProbability$pageFaults;
	}

	@Override
	public final double get$logProbability$pageFaultsMean() {
		return logProbability$pageFaultsMean;
	}

	@Override
	public final double get$logProbability$pageFaultsVar() {
		return logProbability$pageFaultsVar;
	}

	@Override
	public final double get$logProbability$st() {
		return logProbability$st;
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
	public final double[] get$mem() {
		return mem;
	}

	@Override
	public final void set$mem(double[] cv$value) {
		mem = cv$value;
		setFlag$mem = true;
	}

	@Override
	public final double[] get$memMean() {
		return memMean;
	}

	@Override
	public final void set$memMean(double[] cv$value) {
		memMean = cv$value;
		setFlag$memMean = true;
	}

	@Override
	public final double[] get$memVar() {
		return memVar;
	}

	@Override
	public final void set$memVar(double[] cv$value) {
		memVar = cv$value;
		setFlag$memVar = true;
	}

	@Override
	public final double[] get$mem_measured() {
		return mem_measured;
	}

	@Override
	public final void set$mem_measured(double[] cv$value) {
		mem_measured = cv$value;
	}

	@Override
	public final int get$noStates() {
		return noStates;
	}

	@Override
	public final void set$noStates(int cv$value) {
		noStates = cv$value;
	}

	@Override
	public final double[] get$pageFaults() {
		return pageFaults;
	}

	@Override
	public final void set$pageFaults(double[] cv$value) {
		pageFaults = cv$value;
		setFlag$pageFaults = true;
	}

	@Override
	public final double[] get$pageFaultsMean() {
		return pageFaultsMean;
	}

	@Override
	public final void set$pageFaultsMean(double[] cv$value) {
		pageFaultsMean = cv$value;
		setFlag$pageFaultsMean = true;
	}

	@Override
	public final double[] get$pageFaultsVar() {
		return pageFaultsVar;
	}

	@Override
	public final void set$pageFaultsVar(double[] cv$value) {
		pageFaultsVar = cv$value;
		setFlag$pageFaultsVar = true;
	}

	@Override
	public final double[] get$pageFaults_measured() {
		return pageFaults_measured;
	}

	@Override
	public final void set$pageFaults_measured(double[] cv$value) {
		pageFaults_measured = cv$value;
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
	public final double[] get$v() {
		return v;
	}

	private final void logProbabilityDistribution$sample118() {
		if(!fixedProbFlag$sample118) {
			double cv$accumulator = 0.0;
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1) {
				double cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				double cv$probabilityReached = 0.0;
				double cv$sampleValue = cpu[i$var109];
				if((0 == i$var109)) {
					if(fixedFlag$sample34) {
						if((0 <= st[0])) {
							int var52 = st[0];
							if(((0 <= var52) && (var52 < noStates))) {
								cv$distributionAccumulator = DistributionSampling.logProbabilityGaussian(cv$sampleValue, cpuMean[st[0]], cpuVar[st[0]]);
								cv$probabilityReached = 1.0;
							}
						}
					} else {
						for(int index$sample34$3 = 0; index$sample34$3 < noStates; index$sample34$3 += 1) {
							double cv$probabilitySample34Value4 = distribution$sample34[index$sample34$3];
							double cv$weightedProbability = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(cv$sampleValue, cpuMean[index$sample34$3], cpuVar[index$sample34$3]));
							if((cv$weightedProbability < cv$distributionAccumulator))
								cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
							else {
								if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
									cv$distributionAccumulator = cv$weightedProbability;
								else
									cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
							}
							cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample34Value4);
						}
					}
				}
				if((1 <= i$var109)) {
					if(fixedFlag$sample44) {
						if((0 <= st[i$var109])) {
							int var52 = st[i$var109];
							if(((0 <= var52) && (var52 < noStates))) {
								double cv$weightedProbability = DistributionSampling.logProbabilityGaussian(cv$sampleValue, cpuMean[st[i$var109]], cpuVar[st[i$var109]]);
								if((cv$weightedProbability < cv$distributionAccumulator))
									cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
								else {
									if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
										cv$distributionAccumulator = cv$weightedProbability;
									else
										cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
								}
								cv$probabilityReached = (cv$probabilityReached + 1.0);
							}
						}
					} else {
						for(int index$sample44$43 = 0; index$sample44$43 < noStates; index$sample44$43 += 1) {
							double cv$probabilitySample44Value44 = distribution$sample44[(i$var109 - 1)][index$sample44$43];
							double cv$weightedProbability = (Math.log(cv$probabilitySample44Value44) + DistributionSampling.logProbabilityGaussian(cv$sampleValue, cpuMean[index$sample44$43], cpuVar[index$sample44$43]));
							if((cv$weightedProbability < cv$distributionAccumulator))
								cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
							else {
								if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
									cv$distributionAccumulator = cv$weightedProbability;
								else
									cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
							}
							cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample44Value44);
						}
					}
				}
				if((cv$probabilityReached == 0.0))
					cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				else
					cv$distributionAccumulator = (cv$distributionAccumulator - Math.log(cv$probabilityReached));
				cv$accumulator = (cv$accumulator + cv$distributionAccumulator);
				logProbability$var113[i$var109] = cv$distributionAccumulator;
				logProbability$sample118[i$var109] = cv$distributionAccumulator;
			}
			logProbability$cpu = (logProbability$cpu + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			fixedProbFlag$sample118 = ((((fixedFlag$sample118 && fixedFlag$sample34) && fixedFlag$sample44) && fixedFlag$sample57) && fixedFlag$sample89);
		} else {
			double cv$accumulator = 0.0;
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1) {
				double cv$rvAccumulator = logProbability$sample118[i$var109];
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var113[i$var109] = cv$rvAccumulator;
			}
			logProbability$cpu = (logProbability$cpu + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityDistribution$sample123() {
		if(!fixedProbFlag$sample123) {
			double cv$accumulator = 0.0;
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1) {
				double cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				double cv$probabilityReached = 0.0;
				double cv$sampleValue = mem[i$var109];
				if((0 == i$var109)) {
					if(fixedFlag$sample34) {
						if((0 <= st[0])) {
							int var63 = st[0];
							if(((0 <= var63) && (var63 < noStates))) {
								cv$distributionAccumulator = DistributionSampling.logProbabilityGaussian(cv$sampleValue, memMean[st[0]], memVar[st[0]]);
								cv$probabilityReached = 1.0;
							}
						}
					} else {
						for(int index$sample34$3 = 0; index$sample34$3 < noStates; index$sample34$3 += 1) {
							double cv$probabilitySample34Value4 = distribution$sample34[index$sample34$3];
							double cv$weightedProbability = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(cv$sampleValue, memMean[index$sample34$3], memVar[index$sample34$3]));
							if((cv$weightedProbability < cv$distributionAccumulator))
								cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
							else {
								if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
									cv$distributionAccumulator = cv$weightedProbability;
								else
									cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
							}
							cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample34Value4);
						}
					}
				}
				if((1 <= i$var109)) {
					if(fixedFlag$sample44) {
						if((0 <= st[i$var109])) {
							int var63 = st[i$var109];
							if(((0 <= var63) && (var63 < noStates))) {
								double cv$weightedProbability = DistributionSampling.logProbabilityGaussian(cv$sampleValue, memMean[st[i$var109]], memVar[st[i$var109]]);
								if((cv$weightedProbability < cv$distributionAccumulator))
									cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
								else {
									if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
										cv$distributionAccumulator = cv$weightedProbability;
									else
										cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
								}
								cv$probabilityReached = (cv$probabilityReached + 1.0);
							}
						}
					} else {
						for(int index$sample44$43 = 0; index$sample44$43 < noStates; index$sample44$43 += 1) {
							double cv$probabilitySample44Value44 = distribution$sample44[(i$var109 - 1)][index$sample44$43];
							double cv$weightedProbability = (Math.log(cv$probabilitySample44Value44) + DistributionSampling.logProbabilityGaussian(cv$sampleValue, memMean[index$sample44$43], memVar[index$sample44$43]));
							if((cv$weightedProbability < cv$distributionAccumulator))
								cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
							else {
								if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
									cv$distributionAccumulator = cv$weightedProbability;
								else
									cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
							}
							cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample44Value44);
						}
					}
				}
				if((cv$probabilityReached == 0.0))
					cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				else
					cv$distributionAccumulator = (cv$distributionAccumulator - Math.log(cv$probabilityReached));
				cv$accumulator = (cv$accumulator + cv$distributionAccumulator);
				logProbability$var118[i$var109] = cv$distributionAccumulator;
				logProbability$sample123[i$var109] = cv$distributionAccumulator;
			}
			logProbability$mem = (logProbability$mem + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			fixedProbFlag$sample123 = ((((fixedFlag$sample123 && fixedFlag$sample34) && fixedFlag$sample44) && fixedFlag$sample68) && fixedFlag$sample99);
		} else {
			double cv$accumulator = 0.0;
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1) {
				double cv$rvAccumulator = logProbability$sample123[i$var109];
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var118[i$var109] = cv$rvAccumulator;
			}
			logProbability$mem = (logProbability$mem + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityDistribution$sample128() {
		if(!fixedProbFlag$sample128) {
			double cv$accumulator = 0.0;
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1) {
				double cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				double cv$probabilityReached = 0.0;
				double cv$sampleValue = pageFaults[i$var109];
				if((0 == i$var109)) {
					if(fixedFlag$sample34) {
						if((0 <= st[0])) {
							int var74 = st[0];
							if(((0 <= var74) && (var74 < noStates))) {
								cv$distributionAccumulator = DistributionSampling.logProbabilityGaussian(cv$sampleValue, pageFaultsMean[st[0]], pageFaultsVar[st[0]]);
								cv$probabilityReached = 1.0;
							}
						}
					} else {
						for(int index$sample34$3 = 0; index$sample34$3 < noStates; index$sample34$3 += 1) {
							double cv$probabilitySample34Value4 = distribution$sample34[index$sample34$3];
							double cv$weightedProbability = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(cv$sampleValue, pageFaultsMean[index$sample34$3], pageFaultsVar[index$sample34$3]));
							if((cv$weightedProbability < cv$distributionAccumulator))
								cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
							else {
								if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
									cv$distributionAccumulator = cv$weightedProbability;
								else
									cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
							}
							cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample34Value4);
						}
					}
				}
				if((1 <= i$var109)) {
					if(fixedFlag$sample44) {
						if((0 <= st[i$var109])) {
							int var74 = st[i$var109];
							if(((0 <= var74) && (var74 < noStates))) {
								double cv$weightedProbability = DistributionSampling.logProbabilityGaussian(cv$sampleValue, pageFaultsMean[st[i$var109]], pageFaultsVar[st[i$var109]]);
								if((cv$weightedProbability < cv$distributionAccumulator))
									cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
								else {
									if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
										cv$distributionAccumulator = cv$weightedProbability;
									else
										cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
								}
								cv$probabilityReached = (cv$probabilityReached + 1.0);
							}
						}
					} else {
						for(int index$sample44$43 = 0; index$sample44$43 < noStates; index$sample44$43 += 1) {
							double cv$probabilitySample44Value44 = distribution$sample44[(i$var109 - 1)][index$sample44$43];
							double cv$weightedProbability = (Math.log(cv$probabilitySample44Value44) + DistributionSampling.logProbabilityGaussian(cv$sampleValue, pageFaultsMean[index$sample44$43], pageFaultsVar[index$sample44$43]));
							if((cv$weightedProbability < cv$distributionAccumulator))
								cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
							else {
								if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
									cv$distributionAccumulator = cv$weightedProbability;
								else
									cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
							}
							cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample44Value44);
						}
					}
				}
				if((cv$probabilityReached == 0.0))
					cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				else
					cv$distributionAccumulator = (cv$distributionAccumulator - Math.log(cv$probabilityReached));
				cv$accumulator = (cv$accumulator + cv$distributionAccumulator);
				logProbability$var123[i$var109] = cv$distributionAccumulator;
				logProbability$sample128[i$var109] = cv$distributionAccumulator;
			}
			logProbability$pageFaults = (logProbability$pageFaults + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			fixedProbFlag$sample128 = ((((fixedFlag$sample128 && fixedFlag$sample34) && fixedFlag$sample44) && fixedFlag$sample79) && fixedFlag$sample109);
		} else {
			double cv$accumulator = 0.0;
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1) {
				double cv$rvAccumulator = logProbability$sample128[i$var109];
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var123[i$var109] = cv$rvAccumulator;
			}
			logProbability$pageFaults = (logProbability$pageFaults + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityDistribution$sample34() {
		if(!fixedProbFlag$sample34) {
			if(fixedFlag$sample34) {
				double cv$distributionAccumulator = DistributionSampling.logProbabilityCategorical(st[0], initialStateDistribution);
				logProbability$var29 = cv$distributionAccumulator;
				logProbability$var30 = cv$distributionAccumulator;
				logProbability$st = (logProbability$st + cv$distributionAccumulator);
				logProbability$$model = (logProbability$$model + cv$distributionAccumulator);
				logProbability$$evidence = (logProbability$$evidence + cv$distributionAccumulator);
				fixedProbFlag$sample34 = fixedFlag$sample31;
			}
		} else {
			logProbability$var29 = logProbability$var30;
			if(fixedFlag$sample34)
				logProbability$st = (logProbability$st + logProbability$var30);
			logProbability$$model = (logProbability$$model + logProbability$var30);
			if(fixedFlag$sample34)
				logProbability$$evidence = (logProbability$$evidence + logProbability$var30);
		}
	}

	private final void logProbabilityDistribution$sample44() {
		if(!fixedProbFlag$sample44) {
			if(fixedFlag$sample44) {
				double cv$accumulator = 0.0;
				for(int i$var34 = 1; i$var34 < samples; i$var34 += 1) {
					double cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
					double cv$probabilityReached = 0.0;
					int cv$sampleValue = st[i$var34];
					if((1 == i$var34)) {
						if(fixedFlag$sample34) {
							int var21 = st[0];
							if(((0 <= var21) && (var21 < noStates))) {
								cv$distributionAccumulator = DistributionSampling.logProbabilityCategorical(cv$sampleValue, m[st[0]]);
								cv$probabilityReached = 1.0;
							}
						} else {
							for(int index$sample34$4 = 0; index$sample34$4 < noStates; index$sample34$4 += 1) {
								double cv$probabilitySample34Value5 = distribution$sample34[index$sample34$4];
								double cv$weightedProbability = (Math.log(cv$probabilitySample34Value5) + DistributionSampling.logProbabilityCategorical(cv$sampleValue, m[index$sample34$4]));
								if((cv$weightedProbability < cv$distributionAccumulator))
									cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
								else {
									if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
										cv$distributionAccumulator = cv$weightedProbability;
									else
										cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
								}
								cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample34Value5);
							}
						}
					}
					if((2 <= i$var34)) {
						int var21 = st[(i$var34 - 1)];
						if(((0 <= var21) && (var21 < noStates))) {
							double cv$weightedProbability = DistributionSampling.logProbabilityCategorical(cv$sampleValue, m[st[(i$var34 - 1)]]);
							if((cv$weightedProbability < cv$distributionAccumulator))
								cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
							else {
								if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
									cv$distributionAccumulator = cv$weightedProbability;
								else
									cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
							}
							cv$probabilityReached = (cv$probabilityReached + 1.0);
						}
					}
					if((cv$probabilityReached == 0.0))
						cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
					else
						cv$distributionAccumulator = (cv$distributionAccumulator - Math.log(cv$probabilityReached));
					cv$accumulator = (cv$accumulator + cv$distributionAccumulator);
					logProbability$var39[(i$var34 - 1)] = cv$distributionAccumulator;
					logProbability$sample44[(i$var34 - 1)] = cv$distributionAccumulator;
				}
				logProbability$st = (logProbability$st + cv$accumulator);
				logProbability$$model = (logProbability$$model + cv$accumulator);
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
				fixedProbFlag$sample44 = (fixedFlag$sample25 && fixedFlag$sample34);
			}
		} else {
			double cv$accumulator = 0.0;
			for(int i$var34 = 1; i$var34 < samples; i$var34 += 1) {
				double cv$rvAccumulator = logProbability$sample44[(i$var34 - 1)];
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var39[(i$var34 - 1)] = cv$rvAccumulator;
			}
			if(fixedFlag$sample44)
				logProbability$st = (logProbability$st + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			if(fixedFlag$sample44)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityValue$sample109() {
		if(!fixedProbFlag$sample109) {
			double cv$sampleAccumulator = 0.0;
			for(int var104 = 0; var104 < noStates; var104 += 1)
				cv$sampleAccumulator = (cv$sampleAccumulator + DistributionSampling.logProbabilityInverseGamma(pageFaultsVar[var104], 5.0, 0.5));
			logProbability$var100 = cv$sampleAccumulator;
			logProbability$var105 = cv$sampleAccumulator;
			logProbability$pageFaultsVar = (logProbability$pageFaultsVar + cv$sampleAccumulator);
			logProbability$$model = (logProbability$$model + cv$sampleAccumulator);
			if(fixedFlag$sample109)
				logProbability$$evidence = (logProbability$$evidence + cv$sampleAccumulator);
			fixedProbFlag$sample109 = fixedFlag$sample109;
		} else {
			logProbability$var100 = logProbability$var105;
			logProbability$pageFaultsVar = (logProbability$pageFaultsVar + logProbability$var105);
			logProbability$$model = (logProbability$$model + logProbability$var105);
			if(fixedFlag$sample109)
				logProbability$$evidence = (logProbability$$evidence + logProbability$var105);
		}
	}

	private final void logProbabilityValue$sample118() {
		if(!fixedProbFlag$sample118) {
			double cv$accumulator = 0.0;
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1) {
				double cv$distributionAccumulator = DistributionSampling.logProbabilityGaussian(cpu[i$var109], cpuMean[st[i$var109]], cpuVar[st[i$var109]]);
				cv$accumulator = (cv$accumulator + cv$distributionAccumulator);
				logProbability$var113[i$var109] = cv$distributionAccumulator;
				logProbability$sample118[i$var109] = cv$distributionAccumulator;
			}
			logProbability$cpu = (logProbability$cpu + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			fixedProbFlag$sample118 = ((((fixedFlag$sample118 && fixedFlag$sample34) && fixedFlag$sample44) && fixedFlag$sample57) && fixedFlag$sample89);
		} else {
			double cv$accumulator = 0.0;
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1) {
				double cv$rvAccumulator = logProbability$sample118[i$var109];
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var113[i$var109] = cv$rvAccumulator;
			}
			logProbability$cpu = (logProbability$cpu + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityValue$sample123() {
		if(!fixedProbFlag$sample123) {
			double cv$accumulator = 0.0;
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1) {
				double cv$distributionAccumulator = DistributionSampling.logProbabilityGaussian(mem[i$var109], memMean[st[i$var109]], memVar[st[i$var109]]);
				cv$accumulator = (cv$accumulator + cv$distributionAccumulator);
				logProbability$var118[i$var109] = cv$distributionAccumulator;
				logProbability$sample123[i$var109] = cv$distributionAccumulator;
			}
			logProbability$mem = (logProbability$mem + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			fixedProbFlag$sample123 = ((((fixedFlag$sample123 && fixedFlag$sample34) && fixedFlag$sample44) && fixedFlag$sample68) && fixedFlag$sample99);
		} else {
			double cv$accumulator = 0.0;
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1) {
				double cv$rvAccumulator = logProbability$sample123[i$var109];
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var118[i$var109] = cv$rvAccumulator;
			}
			logProbability$mem = (logProbability$mem + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityValue$sample128() {
		if(!fixedProbFlag$sample128) {
			double cv$accumulator = 0.0;
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1) {
				double cv$distributionAccumulator = DistributionSampling.logProbabilityGaussian(pageFaults[i$var109], pageFaultsMean[st[i$var109]], pageFaultsVar[st[i$var109]]);
				cv$accumulator = (cv$accumulator + cv$distributionAccumulator);
				logProbability$var123[i$var109] = cv$distributionAccumulator;
				logProbability$sample128[i$var109] = cv$distributionAccumulator;
			}
			logProbability$pageFaults = (logProbability$pageFaults + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			fixedProbFlag$sample128 = ((((fixedFlag$sample128 && fixedFlag$sample34) && fixedFlag$sample44) && fixedFlag$sample79) && fixedFlag$sample109);
		} else {
			double cv$accumulator = 0.0;
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1) {
				double cv$rvAccumulator = logProbability$sample128[i$var109];
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var123[i$var109] = cv$rvAccumulator;
			}
			logProbability$pageFaults = (logProbability$pageFaults + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityValue$sample25() {
		if(!fixedProbFlag$sample25) {
			double cv$sampleAccumulator = 0.0;
			for(int var21 = 0; var21 < noStates; var21 += 1)
				cv$sampleAccumulator = (cv$sampleAccumulator + DistributionSampling.logProbabilityDirichlet(m[var21], v));
			logProbability$var17 = cv$sampleAccumulator;
			logProbability$var22 = cv$sampleAccumulator;
			logProbability$m = (logProbability$m + cv$sampleAccumulator);
			logProbability$$model = (logProbability$$model + cv$sampleAccumulator);
			if(fixedFlag$sample25)
				logProbability$$evidence = (logProbability$$evidence + cv$sampleAccumulator);
			fixedProbFlag$sample25 = fixedFlag$sample25;
		} else {
			logProbability$var17 = logProbability$var22;
			logProbability$m = (logProbability$m + logProbability$var22);
			logProbability$$model = (logProbability$$model + logProbability$var22);
			if(fixedFlag$sample25)
				logProbability$$evidence = (logProbability$$evidence + logProbability$var22);
		}
	}

	private final void logProbabilityValue$sample31() {
		if(!fixedProbFlag$sample31) {
			double cv$distributionAccumulator = DistributionSampling.logProbabilityDirichlet(initialStateDistribution, v);
			logProbability$var26 = cv$distributionAccumulator;
			logProbability$initialStateDistribution = cv$distributionAccumulator;
			logProbability$$model = (logProbability$$model + cv$distributionAccumulator);
			if(fixedFlag$sample31)
				logProbability$$evidence = (logProbability$$evidence + cv$distributionAccumulator);
			fixedProbFlag$sample31 = fixedFlag$sample31;
		} else {
			logProbability$var26 = logProbability$initialStateDistribution;
			logProbability$$model = (logProbability$$model + logProbability$initialStateDistribution);
			if(fixedFlag$sample31)
				logProbability$$evidence = (logProbability$$evidence + logProbability$initialStateDistribution);
		}
	}

	private final void logProbabilityValue$sample34() {
		if(!fixedProbFlag$sample34) {
			double cv$distributionAccumulator = DistributionSampling.logProbabilityCategorical(st[0], initialStateDistribution);
			logProbability$var29 = cv$distributionAccumulator;
			logProbability$var30 = cv$distributionAccumulator;
			logProbability$st = (logProbability$st + cv$distributionAccumulator);
			logProbability$$model = (logProbability$$model + cv$distributionAccumulator);
			if(fixedFlag$sample34)
				logProbability$$evidence = (logProbability$$evidence + cv$distributionAccumulator);
			fixedProbFlag$sample34 = (fixedFlag$sample34 && fixedFlag$sample31);
		} else {
			logProbability$var29 = logProbability$var30;
			logProbability$st = (logProbability$st + logProbability$var30);
			logProbability$$model = (logProbability$$model + logProbability$var30);
			if(fixedFlag$sample34)
				logProbability$$evidence = (logProbability$$evidence + logProbability$var30);
		}
	}

	private final void logProbabilityValue$sample44() {
		if(!fixedProbFlag$sample44) {
			double cv$accumulator = 0.0;
			for(int i$var34 = 1; i$var34 < samples; i$var34 += 1) {
				double cv$distributionAccumulator = DistributionSampling.logProbabilityCategorical(st[i$var34], m[st[(i$var34 - 1)]]);
				cv$accumulator = (cv$accumulator + cv$distributionAccumulator);
				logProbability$var39[(i$var34 - 1)] = cv$distributionAccumulator;
				logProbability$sample44[(i$var34 - 1)] = cv$distributionAccumulator;
			}
			logProbability$st = (logProbability$st + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			if(fixedFlag$sample44)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			fixedProbFlag$sample44 = ((fixedFlag$sample44 && fixedFlag$sample25) && fixedFlag$sample34);
		} else {
			double cv$accumulator = 0.0;
			for(int i$var34 = 1; i$var34 < samples; i$var34 += 1) {
				double cv$rvAccumulator = logProbability$sample44[(i$var34 - 1)];
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var39[(i$var34 - 1)] = cv$rvAccumulator;
			}
			logProbability$st = (logProbability$st + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			if(fixedFlag$sample44)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityValue$sample57() {
		if(!fixedProbFlag$sample57) {
			double cv$sampleAccumulator = 0.0;
			for(int var52 = 0; var52 < noStates; var52 += 1)
				cv$sampleAccumulator = (cv$sampleAccumulator + DistributionSampling.logProbabilityGaussian(cpuMean[var52], 16.0, 8.6));
			logProbability$var48 = cv$sampleAccumulator;
			logProbability$var53 = cv$sampleAccumulator;
			logProbability$cpuMean = (logProbability$cpuMean + cv$sampleAccumulator);
			logProbability$$model = (logProbability$$model + cv$sampleAccumulator);
			if(fixedFlag$sample57)
				logProbability$$evidence = (logProbability$$evidence + cv$sampleAccumulator);
			fixedProbFlag$sample57 = fixedFlag$sample57;
		} else {
			logProbability$var48 = logProbability$var53;
			logProbability$cpuMean = (logProbability$cpuMean + logProbability$var53);
			logProbability$$model = (logProbability$$model + logProbability$var53);
			if(fixedFlag$sample57)
				logProbability$$evidence = (logProbability$$evidence + logProbability$var53);
		}
	}

	private final void logProbabilityValue$sample68() {
		if(!fixedProbFlag$sample68) {
			double cv$sampleAccumulator = 0.0;
			for(int var63 = 0; var63 < noStates; var63 += 1)
				cv$sampleAccumulator = (cv$sampleAccumulator + DistributionSampling.logProbabilityGaussian(memMean[var63], 94.0, 1.0));
			logProbability$var59 = cv$sampleAccumulator;
			logProbability$var64 = cv$sampleAccumulator;
			logProbability$memMean = (logProbability$memMean + cv$sampleAccumulator);
			logProbability$$model = (logProbability$$model + cv$sampleAccumulator);
			if(fixedFlag$sample68)
				logProbability$$evidence = (logProbability$$evidence + cv$sampleAccumulator);
			fixedProbFlag$sample68 = fixedFlag$sample68;
		} else {
			logProbability$var59 = logProbability$var64;
			logProbability$memMean = (logProbability$memMean + logProbability$var64);
			logProbability$$model = (logProbability$$model + logProbability$var64);
			if(fixedFlag$sample68)
				logProbability$$evidence = (logProbability$$evidence + logProbability$var64);
		}
	}

	private final void logProbabilityValue$sample79() {
		if(!fixedProbFlag$sample79) {
			double cv$sampleAccumulator = 0.0;
			for(int var74 = 0; var74 < noStates; var74 += 1)
				cv$sampleAccumulator = (cv$sampleAccumulator + DistributionSampling.logProbabilityGaussian(pageFaultsMean[var74], 814.0, 335550.0));
			logProbability$var70 = cv$sampleAccumulator;
			logProbability$var75 = cv$sampleAccumulator;
			logProbability$pageFaultsMean = (logProbability$pageFaultsMean + cv$sampleAccumulator);
			logProbability$$model = (logProbability$$model + cv$sampleAccumulator);
			if(fixedFlag$sample79)
				logProbability$$evidence = (logProbability$$evidence + cv$sampleAccumulator);
			fixedProbFlag$sample79 = fixedFlag$sample79;
		} else {
			logProbability$var70 = logProbability$var75;
			logProbability$pageFaultsMean = (logProbability$pageFaultsMean + logProbability$var75);
			logProbability$$model = (logProbability$$model + logProbability$var75);
			if(fixedFlag$sample79)
				logProbability$$evidence = (logProbability$$evidence + logProbability$var75);
		}
	}

	private final void logProbabilityValue$sample89() {
		if(!fixedProbFlag$sample89) {
			double cv$sampleAccumulator = 0.0;
			for(int var84 = 0; var84 < noStates; var84 += 1)
				cv$sampleAccumulator = (cv$sampleAccumulator + DistributionSampling.logProbabilityInverseGamma(cpuVar[var84], 5.0, 0.5));
			logProbability$var80 = cv$sampleAccumulator;
			logProbability$var85 = cv$sampleAccumulator;
			logProbability$cpuVar = (logProbability$cpuVar + cv$sampleAccumulator);
			logProbability$$model = (logProbability$$model + cv$sampleAccumulator);
			if(fixedFlag$sample89)
				logProbability$$evidence = (logProbability$$evidence + cv$sampleAccumulator);
			fixedProbFlag$sample89 = fixedFlag$sample89;
		} else {
			logProbability$var80 = logProbability$var85;
			logProbability$cpuVar = (logProbability$cpuVar + logProbability$var85);
			logProbability$$model = (logProbability$$model + logProbability$var85);
			if(fixedFlag$sample89)
				logProbability$$evidence = (logProbability$$evidence + logProbability$var85);
		}
	}

	private final void logProbabilityValue$sample99() {
		if(!fixedProbFlag$sample99) {
			double cv$sampleAccumulator = 0.0;
			for(int var94 = 0; var94 < noStates; var94 += 1)
				cv$sampleAccumulator = (cv$sampleAccumulator + DistributionSampling.logProbabilityInverseGamma(memVar[var94], 5.0, 0.5));
			logProbability$var90 = cv$sampleAccumulator;
			logProbability$var95 = cv$sampleAccumulator;
			logProbability$memVar = (logProbability$memVar + cv$sampleAccumulator);
			logProbability$$model = (logProbability$$model + cv$sampleAccumulator);
			if(fixedFlag$sample99)
				logProbability$$evidence = (logProbability$$evidence + cv$sampleAccumulator);
			fixedProbFlag$sample99 = fixedFlag$sample99;
		} else {
			logProbability$var90 = logProbability$var95;
			logProbability$memVar = (logProbability$memVar + logProbability$var95);
			logProbability$$model = (logProbability$$model + logProbability$var95);
			if(fixedFlag$sample99)
				logProbability$$evidence = (logProbability$$evidence + logProbability$var95);
		}
	}

	private final void sample109(int var104, int threadID$cv$var104, Rng RNG$) {
		double cv$originalValue = pageFaultsVar[var104];
		double cv$originalProbability;
		double cv$var = ((cv$originalValue * cv$originalValue) * 0.010000000000000002);
		if((cv$var < 0.010000000000000002))
			cv$var = 0.010000000000000002;
		double cv$proposedValue = DistributionSampling.sampleGaussian(RNG$, cv$originalValue, cv$var);
		{
			double cv$accumulatedProbabilities = DistributionSampling.logProbabilityInverseGamma(cv$originalValue, 5.0, 0.5);
			if((0 < samples)) {
				if(fixedFlag$sample34) {
					if((var104 == st[0])) {
						double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
						double cv$consumerDistributionProbabilityAccumulator = 1.0;
						int var74 = st[0];
						if(((0 <= var74) && (var74 < noStates))) {
							cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(pageFaults[0], pageFaultsMean[st[0]], cv$originalValue);
							cv$consumerDistributionProbabilityAccumulator = 0.0;
						}
						cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
						if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
							cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
						else {
							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
								cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
							else
								cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
						}
					}
				} else {
					double cv$probabilitySample34Value4 = distribution$sample34[var104];
					double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(pageFaults[0], pageFaultsMean[var104], cv$originalValue));
					double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample34Value4), 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			}
			for(int i$var109 = 1; i$var109 < samples; i$var109 += 1) {
				if(fixedFlag$sample44) {
					if((var104 == st[i$var109])) {
						double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
						double cv$consumerDistributionProbabilityAccumulator = 1.0;
						int var74 = st[i$var109];
						if(((0 <= var74) && (var74 < noStates))) {
							cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(pageFaults[i$var109], pageFaultsMean[st[i$var109]], cv$originalValue);
							cv$consumerDistributionProbabilityAccumulator = 0.0;
						}
						cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
						if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
							cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
						else {
							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
								cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
							else
								cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
						}
					}
				} else {
					double cv$probabilitySample44Value13 = distribution$sample44[(i$var109 - 1)][var104];
					double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample44Value13) + DistributionSampling.logProbabilityGaussian(pageFaults[i$var109], pageFaultsMean[var104], cv$originalValue));
					double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample44Value13), 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			}
			cv$originalProbability = cv$accumulatedProbabilities;
		}
		pageFaultsVar[var104] = cv$proposedValue;
		double cv$accumulatedProbabilities = DistributionSampling.logProbabilityInverseGamma(cv$proposedValue, 5.0, 0.5);
		if((0 < samples)) {
			if(fixedFlag$sample34) {
				if((var104 == st[0])) {
					double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
					double cv$consumerDistributionProbabilityAccumulator = 1.0;
					int var74 = st[0];
					if(((0 <= var74) && (var74 < noStates))) {
						cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(pageFaults[0], pageFaultsMean[st[0]], cv$proposedValue);
						cv$consumerDistributionProbabilityAccumulator = 0.0;
					}
					cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			} else {
				double cv$probabilitySample34Value4 = distribution$sample34[var104];
				double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(pageFaults[0], pageFaultsMean[var104], cv$proposedValue));
				double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample34Value4), 0.0);
				if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
					cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
				else {
					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
						cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
					else
						cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
				}
			}
		}
		for(int i$var109 = 1; i$var109 < samples; i$var109 += 1) {
			if(fixedFlag$sample44) {
				if((var104 == st[i$var109])) {
					double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
					double cv$consumerDistributionProbabilityAccumulator = 1.0;
					int var74 = st[i$var109];
					if(((0 <= var74) && (var74 < noStates))) {
						cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(pageFaults[i$var109], pageFaultsMean[st[i$var109]], cv$proposedValue);
						cv$consumerDistributionProbabilityAccumulator = 0.0;
					}
					cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			} else {
				double cv$probabilitySample44Value13 = distribution$sample44[(i$var109 - 1)][var104];
				double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample44Value13) + DistributionSampling.logProbabilityGaussian(pageFaults[i$var109], pageFaultsMean[var104], cv$proposedValue));
				double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample44Value13), 0.0);
				if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
					cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
				else {
					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
						cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
					else
						cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
				}
			}
		}
		if((((cv$accumulatedProbabilities - cv$originalProbability) <= Math.log(DistributionSampling.sampleUniform(RNG$, 0.0, 1.0))) || Double.isNaN((cv$accumulatedProbabilities - cv$originalProbability))))
			pageFaultsVar[var104] = cv$originalValue;
	}

	private final void sample25(int var21, int threadID$cv$var21, Rng RNG$) {
		double[] cv$countLocal = cv$var22$countGlobal[threadID$cv$var21];
		for(int cv$loopIndex = 0; cv$loopIndex < noStates; cv$loopIndex += 1)
			cv$countLocal[cv$loopIndex] = 0.0;
		if(fixedFlag$sample44) {
			if((1 < samples)) {
				if(fixedFlag$sample34) {
					if((var21 == st[0]))
						cv$countLocal[st[1]] = (cv$countLocal[st[1]] + 1.0);
				} else
					cv$countLocal[st[1]] = (cv$countLocal[st[1]] + distribution$sample34[var21]);
			}
			for(int i$var34 = 2; i$var34 < samples; i$var34 += 1) {
				if((var21 == st[(i$var34 - 1)]))
					cv$countLocal[st[i$var34]] = (cv$countLocal[st[i$var34]] + 1.0);
			}
		} else {
			if((1 < samples)) {
				if(fixedFlag$sample34) {
					if((var21 == st[0])) {
						for(int cv$loopIndex = 0; cv$loopIndex < noStates; cv$loopIndex += 1)
							cv$countLocal[cv$loopIndex] = (cv$countLocal[cv$loopIndex] + distribution$sample44[0][cv$loopIndex]);
					}
				} else {
					double cv$distributionProbability = distribution$sample34[var21];
					for(int cv$loopIndex = 0; cv$loopIndex < noStates; cv$loopIndex += 1)
						cv$countLocal[cv$loopIndex] = (cv$countLocal[cv$loopIndex] + (distribution$sample44[0][cv$loopIndex] * cv$distributionProbability));
				}
			}
			for(int i$var34 = 1; i$var34 < samples; i$var34 += 1) {
				int index$i$40 = (i$var34 - 1);
				if((1 <= index$i$40)) {
					double cv$distributionProbability = distribution$sample44[(index$i$40 - 1)][var21];
					for(int cv$loopIndex = 0; cv$loopIndex < noStates; cv$loopIndex += 1)
						cv$countLocal[cv$loopIndex] = (cv$countLocal[cv$loopIndex] + (distribution$sample44[(i$var34 - 1)][cv$loopIndex] * cv$distributionProbability));
				}
			}
		}
		Conjugates.sampleConjugateDirichletCategorical(RNG$, v, cv$countLocal, m[var21]);
	}

	private final void sample31() {
		for(int cv$loopIndex = 0; cv$loopIndex < noStates; cv$loopIndex += 1)
			cv$var27$countGlobal[cv$loopIndex] = 0.0;
		if(fixedFlag$sample34)
			cv$var27$countGlobal[st[0]] = (cv$var27$countGlobal[st[0]] + 1.0);
		else {
			for(int cv$loopIndex = 0; cv$loopIndex < noStates; cv$loopIndex += 1)
				cv$var27$countGlobal[cv$loopIndex] = (cv$var27$countGlobal[cv$loopIndex] + distribution$sample34[cv$loopIndex]);
		}
		Conjugates.sampleConjugateDirichletCategorical(RNG$, v, cv$var27$countGlobal, initialStateDistribution);
	}

	private final void sample34() {
		for(int cv$valuePos = 0; cv$valuePos < noStates; cv$valuePos += 1) {
			double cv$accumulatedDistributionProbabilities = 0.0;
			double cv$accumulatedProbabilities = DistributionSampling.logProbabilityCategorical(cv$valuePos, initialStateDistribution);
			if((fixedFlag$sample44 && (1 < samples)))
				cv$accumulatedProbabilities = (DistributionSampling.logProbabilityCategorical(st[1], m[cv$valuePos]) + cv$accumulatedProbabilities);
			if((0 < samples)) {
				guard$sample34gaussian117$global[0] = false;
				if(!guard$sample34gaussian117$global[0]) {
					guard$sample34gaussian117$global[0] = true;
					cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(cpu[0], cpuMean[cv$valuePos], cpuVar[cv$valuePos]) + cv$accumulatedProbabilities);
				}
				if(!guard$sample34gaussian117$global[0]) {
					guard$sample34gaussian117$global[0] = true;
					cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(cpu[0], cpuMean[cv$valuePos], cpuVar[cv$valuePos]) + cv$accumulatedProbabilities);
				}
				guard$sample34gaussian122$global[0] = false;
				if(!guard$sample34gaussian122$global[0]) {
					guard$sample34gaussian122$global[0] = true;
					cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(mem[0], memMean[cv$valuePos], memVar[cv$valuePos]) + cv$accumulatedProbabilities);
				}
				if(!guard$sample34gaussian122$global[0]) {
					guard$sample34gaussian122$global[0] = true;
					cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(mem[0], memMean[cv$valuePos], memVar[cv$valuePos]) + cv$accumulatedProbabilities);
				}
				guard$sample34gaussian127$global[0] = false;
				if(!guard$sample34gaussian127$global[0]) {
					guard$sample34gaussian127$global[0] = true;
					cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(pageFaults[0], pageFaultsMean[cv$valuePos], pageFaultsVar[cv$valuePos]) + cv$accumulatedProbabilities);
				}
				if(!guard$sample34gaussian127$global[0]) {
					guard$sample34gaussian127$global[0] = true;
					cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(pageFaults[0], pageFaultsMean[cv$valuePos], pageFaultsVar[cv$valuePos]) + cv$accumulatedProbabilities);
				}
			}
			if((!fixedFlag$sample44 && (1 < samples))) {
				for(int cv$i = 0; cv$i < noStates; cv$i += 1)
					cv$distributionAccumulator$var39[cv$i] = 0.0;
				DistributionSampling.addProbabilityDistributionCategorical(cv$distributionAccumulator$var39, 1.0, m[cv$valuePos]);
				double[] cv$sampleDistribution = distribution$sample44[0];
				double cv$overlap = 0.0;
				for(int cv$i = 0; cv$i < noStates; cv$i += 1) {
					double cv$normalisedDistValue = cv$distributionAccumulator$var39[cv$i];
					double cv$sampleDistValue = cv$sampleDistribution[cv$i];
					if((cv$sampleDistValue < cv$normalisedDistValue))
						cv$overlap = (cv$overlap + cv$sampleDistValue);
					else
						cv$overlap = (cv$overlap + cv$normalisedDistValue);
				}
				cv$accumulatedDistributionProbabilities = Math.log(cv$overlap);
			}
			cv$var30$stateProbabilityGlobal[cv$valuePos] = (cv$accumulatedProbabilities + cv$accumulatedDistributionProbabilities);
		}
		double cv$logSum;
		double cv$lseMax = cv$var30$stateProbabilityGlobal[0];
		for(int cv$lseIndex = 1; cv$lseIndex < cv$var30$stateProbabilityGlobal.length; cv$lseIndex += 1) {
			double cv$lseElementValue = cv$var30$stateProbabilityGlobal[cv$lseIndex];
			if((cv$lseMax < cv$lseElementValue))
				cv$lseMax = cv$lseElementValue;
		}
		if((cv$lseMax == Double.NEGATIVE_INFINITY))
			cv$logSum = Double.NEGATIVE_INFINITY;
		else {
			double cv$lseSum = 0.0;
			for(int cv$lseIndex = 0; cv$lseIndex < cv$var30$stateProbabilityGlobal.length; cv$lseIndex += 1)
				cv$lseSum = (cv$lseSum + Math.exp((cv$var30$stateProbabilityGlobal[cv$lseIndex] - cv$lseMax)));
			cv$logSum = (Math.log(cv$lseSum) + cv$lseMax);
		}
		if((cv$logSum == Double.NEGATIVE_INFINITY)) {
			for(int cv$indexName = 0; cv$indexName < cv$var30$stateProbabilityGlobal.length; cv$indexName += 1)
				distribution$sample34[cv$indexName] = (1.0 / cv$var30$stateProbabilityGlobal.length);
		} else {
			for(int cv$indexName = 0; cv$indexName < cv$var30$stateProbabilityGlobal.length; cv$indexName += 1)
				distribution$sample34[cv$indexName] = Math.exp((cv$var30$stateProbabilityGlobal[cv$indexName] - cv$logSum));
		}
	}

	private final void sample44(int i$var34) {
		for(int cv$valuePos = 0; cv$valuePos < noStates; cv$valuePos += 1) {
			double cv$stateProbabilityValue = Double.NEGATIVE_INFINITY;
			double cv$reachedDistributionSourceRV = 0.0;
			double cv$accumulatedDistributionProbabilities = 0.0;
			if((1 == i$var34)) {
				if(fixedFlag$sample34) {
					int var21 = st[0];
					if(((0 <= var21) && (var21 < noStates))) {
						cv$reachedDistributionSourceRV = 1.0;
						double cv$accumulatedProbabilities = DistributionSampling.logProbabilityCategorical(cv$valuePos, m[st[0]]);
						guard$sample44gaussian117$global[1] = false;
						if(!guard$sample44gaussian117$global[1]) {
							guard$sample44gaussian117$global[1] = true;
							cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(cpu[1], cpuMean[cv$valuePos], cpuVar[cv$valuePos]) + cv$accumulatedProbabilities);
						}
						if(!guard$sample44gaussian117$global[1]) {
							guard$sample44gaussian117$global[1] = true;
							cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(cpu[1], cpuMean[cv$valuePos], cpuVar[cv$valuePos]) + cv$accumulatedProbabilities);
						}
						guard$sample44gaussian122$global[1] = false;
						if(!guard$sample44gaussian122$global[1]) {
							guard$sample44gaussian122$global[1] = true;
							cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(mem[1], memMean[cv$valuePos], memVar[cv$valuePos]) + cv$accumulatedProbabilities);
						}
						if(!guard$sample44gaussian122$global[1]) {
							guard$sample44gaussian122$global[1] = true;
							cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(mem[1], memMean[cv$valuePos], memVar[cv$valuePos]) + cv$accumulatedProbabilities);
						}
						guard$sample44gaussian127$global[1] = false;
						if(!guard$sample44gaussian127$global[1]) {
							guard$sample44gaussian127$global[1] = true;
							cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(pageFaults[1], pageFaultsMean[cv$valuePos], pageFaultsVar[cv$valuePos]) + cv$accumulatedProbabilities);
						}
						if(!guard$sample44gaussian127$global[1]) {
							guard$sample44gaussian127$global[1] = true;
							cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(pageFaults[1], pageFaultsMean[cv$valuePos], pageFaultsVar[cv$valuePos]) + cv$accumulatedProbabilities);
						}
						cv$stateProbabilityValue = cv$accumulatedProbabilities;
					}
				} else {
					for(int index$sample34$3 = 0; index$sample34$3 < noStates; index$sample34$3 += 1) {
						double cv$probabilitySample34Value4 = distribution$sample34[index$sample34$3];
						cv$reachedDistributionSourceRV = (cv$reachedDistributionSourceRV + cv$probabilitySample34Value4);
						double cv$accumulatedProbabilities = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityCategorical(cv$valuePos, m[index$sample34$3]));
						guard$sample44gaussian117$global[1] = false;
						if(!guard$sample44gaussian117$global[1]) {
							guard$sample44gaussian117$global[1] = true;
							cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(cpu[1], cpuMean[cv$valuePos], cpuVar[cv$valuePos]) + cv$accumulatedProbabilities);
						}
						if(!guard$sample44gaussian117$global[1]) {
							guard$sample44gaussian117$global[1] = true;
							cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(cpu[1], cpuMean[cv$valuePos], cpuVar[cv$valuePos]) + cv$accumulatedProbabilities);
						}
						guard$sample44gaussian122$global[1] = false;
						if(!guard$sample44gaussian122$global[1]) {
							guard$sample44gaussian122$global[1] = true;
							cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(mem[1], memMean[cv$valuePos], memVar[cv$valuePos]) + cv$accumulatedProbabilities);
						}
						if(!guard$sample44gaussian122$global[1]) {
							guard$sample44gaussian122$global[1] = true;
							cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(mem[1], memMean[cv$valuePos], memVar[cv$valuePos]) + cv$accumulatedProbabilities);
						}
						guard$sample44gaussian127$global[1] = false;
						if(!guard$sample44gaussian127$global[1]) {
							guard$sample44gaussian127$global[1] = true;
							cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(pageFaults[1], pageFaultsMean[cv$valuePos], pageFaultsVar[cv$valuePos]) + cv$accumulatedProbabilities);
						}
						if(!guard$sample44gaussian127$global[1]) {
							guard$sample44gaussian127$global[1] = true;
							cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(pageFaults[1], pageFaultsMean[cv$valuePos], pageFaultsVar[cv$valuePos]) + cv$accumulatedProbabilities);
						}
						if((cv$accumulatedProbabilities < cv$stateProbabilityValue))
							cv$stateProbabilityValue = (Math.log((Math.exp((cv$accumulatedProbabilities - cv$stateProbabilityValue)) + 1)) + cv$stateProbabilityValue);
						else {
							if((cv$stateProbabilityValue == Double.NEGATIVE_INFINITY))
								cv$stateProbabilityValue = cv$accumulatedProbabilities;
							else
								cv$stateProbabilityValue = (Math.log((Math.exp((cv$stateProbabilityValue - cv$accumulatedProbabilities)) + 1)) + cv$accumulatedProbabilities);
						}
					}
				}
			}
			int index$i$10 = (i$var34 - 1);
			if(((1 <= index$i$10) && !(index$i$10 == i$var34))) {
				for(int index$sample44$11 = 0; index$sample44$11 < noStates; index$sample44$11 += 1) {
					double cv$probabilitySample44Value12 = distribution$sample44[(index$i$10 - 1)][index$sample44$11];
					cv$reachedDistributionSourceRV = (cv$reachedDistributionSourceRV + cv$probabilitySample44Value12);
					double cv$accumulatedProbabilities = (Math.log(cv$probabilitySample44Value12) + DistributionSampling.logProbabilityCategorical(cv$valuePos, m[index$sample44$11]));
					guard$sample44gaussian117$global[i$var34] = false;
					if(!guard$sample44gaussian117$global[i$var34]) {
						guard$sample44gaussian117$global[i$var34] = true;
						cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(cpu[i$var34], cpuMean[cv$valuePos], cpuVar[cv$valuePos]) + cv$accumulatedProbabilities);
					}
					if(!guard$sample44gaussian117$global[i$var34]) {
						guard$sample44gaussian117$global[i$var34] = true;
						cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(cpu[i$var34], cpuMean[cv$valuePos], cpuVar[cv$valuePos]) + cv$accumulatedProbabilities);
					}
					guard$sample44gaussian122$global[i$var34] = false;
					if(!guard$sample44gaussian122$global[i$var34]) {
						guard$sample44gaussian122$global[i$var34] = true;
						cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(mem[i$var34], memMean[cv$valuePos], memVar[cv$valuePos]) + cv$accumulatedProbabilities);
					}
					if(!guard$sample44gaussian122$global[i$var34]) {
						guard$sample44gaussian122$global[i$var34] = true;
						cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(mem[i$var34], memMean[cv$valuePos], memVar[cv$valuePos]) + cv$accumulatedProbabilities);
					}
					guard$sample44gaussian127$global[i$var34] = false;
					if(!guard$sample44gaussian127$global[i$var34]) {
						guard$sample44gaussian127$global[i$var34] = true;
						cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(pageFaults[i$var34], pageFaultsMean[cv$valuePos], pageFaultsVar[cv$valuePos]) + cv$accumulatedProbabilities);
					}
					if(!guard$sample44gaussian127$global[i$var34]) {
						guard$sample44gaussian127$global[i$var34] = true;
						cv$accumulatedProbabilities = (DistributionSampling.logProbabilityGaussian(pageFaults[i$var34], pageFaultsMean[cv$valuePos], pageFaultsVar[cv$valuePos]) + cv$accumulatedProbabilities);
					}
					if((cv$accumulatedProbabilities < cv$stateProbabilityValue))
						cv$stateProbabilityValue = (Math.log((Math.exp((cv$accumulatedProbabilities - cv$stateProbabilityValue)) + 1)) + cv$stateProbabilityValue);
					else {
						if((cv$stateProbabilityValue == Double.NEGATIVE_INFINITY))
							cv$stateProbabilityValue = cv$accumulatedProbabilities;
						else
							cv$stateProbabilityValue = (Math.log((Math.exp((cv$stateProbabilityValue - cv$accumulatedProbabilities)) + 1)) + cv$accumulatedProbabilities);
					}
				}
			}
			int index$i$603_2 = (i$var34 + 1);
			if((index$i$603_2 < samples)) {
				for(int cv$i = 0; cv$i < noStates; cv$i += 1)
					cv$distributionAccumulator$var39[cv$i] = 0.0;
				double scopeVariable$reachedSourceProbability = 0.0;
				if((1 == i$var34)) {
					if(fixedFlag$sample34) {
						int index$var21$612_1 = st[0];
						if(((0 <= index$var21$612_1) && (index$var21$612_1 < noStates)))
							scopeVariable$reachedSourceProbability = 1.0;
					} else {
						for(int index$sample34$608 = 0; index$sample34$608 < noStates; index$sample34$608 += 1)
							scopeVariable$reachedSourceProbability = (scopeVariable$reachedSourceProbability + distribution$sample34[index$sample34$608]);
					}
				}
				int index$i$615 = (i$var34 - 1);
				if((((1 <= index$i$615) && !(index$i$615 == i$var34)) && !(index$i$615 == index$i$603_2))) {
					for(int index$sample44$616 = 0; index$sample44$616 < noStates; index$sample44$616 += 1)
						scopeVariable$reachedSourceProbability = (scopeVariable$reachedSourceProbability + distribution$sample44[(index$i$615 - 1)][index$sample44$616]);
				}
				DistributionSampling.addProbabilityDistributionCategorical(cv$distributionAccumulator$var39, scopeVariable$reachedSourceProbability, m[cv$valuePos]);
				double[] cv$sampleDistribution = distribution$sample44[(index$i$603_2 - 1)];
				double cv$overlap = 0.0;
				for(int cv$i = 0; cv$i < noStates; cv$i += 1) {
					double cv$normalisedDistValue = (cv$distributionAccumulator$var39[cv$i] / scopeVariable$reachedSourceProbability);
					double cv$sampleDistValue = cv$sampleDistribution[cv$i];
					if((cv$sampleDistValue < cv$normalisedDistValue))
						cv$overlap = (cv$overlap + cv$sampleDistValue);
					else
						cv$overlap = (cv$overlap + cv$normalisedDistValue);
				}
				cv$accumulatedDistributionProbabilities = Math.log((((cv$overlap * scopeVariable$reachedSourceProbability) + 1.0) - Math.min(scopeVariable$reachedSourceProbability, 1.0)));
			}
			cv$var40$stateProbabilityGlobal[cv$valuePos] = ((cv$stateProbabilityValue + cv$accumulatedDistributionProbabilities) - Math.log(cv$reachedDistributionSourceRV));
		}
		double[] cv$localProbability = distribution$sample44[(i$var34 - 1)];
		double cv$logSum;
		double cv$lseMax = cv$var40$stateProbabilityGlobal[0];
		for(int cv$lseIndex = 1; cv$lseIndex < cv$var40$stateProbabilityGlobal.length; cv$lseIndex += 1) {
			double cv$lseElementValue = cv$var40$stateProbabilityGlobal[cv$lseIndex];
			if((cv$lseMax < cv$lseElementValue))
				cv$lseMax = cv$lseElementValue;
		}
		if((cv$lseMax == Double.NEGATIVE_INFINITY))
			cv$logSum = Double.NEGATIVE_INFINITY;
		else {
			double cv$lseSum = 0.0;
			for(int cv$lseIndex = 0; cv$lseIndex < cv$var40$stateProbabilityGlobal.length; cv$lseIndex += 1)
				cv$lseSum = (cv$lseSum + Math.exp((cv$var40$stateProbabilityGlobal[cv$lseIndex] - cv$lseMax)));
			cv$logSum = (Math.log(cv$lseSum) + cv$lseMax);
		}
		if((cv$logSum == Double.NEGATIVE_INFINITY)) {
			for(int cv$indexName = 0; cv$indexName < cv$var40$stateProbabilityGlobal.length; cv$indexName += 1)
				cv$localProbability[cv$indexName] = (1.0 / cv$var40$stateProbabilityGlobal.length);
		} else {
			for(int cv$indexName = 0; cv$indexName < cv$var40$stateProbabilityGlobal.length; cv$indexName += 1)
				cv$localProbability[cv$indexName] = Math.exp((cv$var40$stateProbabilityGlobal[cv$indexName] - cv$logSum));
		}
	}

	private final void sample57(int var52, int threadID$cv$var52, Rng RNG$) {
		double cv$originalValue = cpuMean[var52];
		double cv$originalProbability;
		double cv$var = ((cv$originalValue * cv$originalValue) * 0.010000000000000002);
		if((cv$var < 0.010000000000000002))
			cv$var = 0.010000000000000002;
		double cv$proposedValue = DistributionSampling.sampleGaussian(RNG$, cv$originalValue, cv$var);
		{
			double cv$accumulatedProbabilities = DistributionSampling.logProbabilityGaussian(cv$originalValue, 16.0, 8.6);
			if((0 < samples)) {
				if(fixedFlag$sample34) {
					if((var52 == st[0])) {
						double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
						double cv$consumerDistributionProbabilityAccumulator = 1.0;
						int var84 = st[0];
						if(((0 <= var84) && (var84 < noStates))) {
							cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(cpu[0], cv$originalValue, cpuVar[st[0]]);
							cv$consumerDistributionProbabilityAccumulator = 0.0;
						}
						cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
						if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
							cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
						else {
							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
								cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
							else
								cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
						}
					}
				} else {
					double cv$probabilitySample34Value4 = distribution$sample34[var52];
					double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(cpu[0], cv$originalValue, cpuVar[var52]));
					double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample34Value4), 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			}
			for(int i$var109 = 1; i$var109 < samples; i$var109 += 1) {
				if(fixedFlag$sample44) {
					if((var52 == st[i$var109])) {
						double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
						double cv$consumerDistributionProbabilityAccumulator = 1.0;
						int var84 = st[i$var109];
						if(((0 <= var84) && (var84 < noStates))) {
							cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(cpu[i$var109], cv$originalValue, cpuVar[st[i$var109]]);
							cv$consumerDistributionProbabilityAccumulator = 0.0;
						}
						cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
						if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
							cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
						else {
							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
								cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
							else
								cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
						}
					}
				} else {
					double cv$probabilitySample44Value13 = distribution$sample44[(i$var109 - 1)][var52];
					double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample44Value13) + DistributionSampling.logProbabilityGaussian(cpu[i$var109], cv$originalValue, cpuVar[var52]));
					double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample44Value13), 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			}
			cv$originalProbability = cv$accumulatedProbabilities;
		}
		cpuMean[var52] = cv$proposedValue;
		double cv$accumulatedProbabilities = DistributionSampling.logProbabilityGaussian(cv$proposedValue, 16.0, 8.6);
		if((0 < samples)) {
			if(fixedFlag$sample34) {
				if((var52 == st[0])) {
					double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
					double cv$consumerDistributionProbabilityAccumulator = 1.0;
					int var84 = st[0];
					if(((0 <= var84) && (var84 < noStates))) {
						cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(cpu[0], cv$proposedValue, cpuVar[st[0]]);
						cv$consumerDistributionProbabilityAccumulator = 0.0;
					}
					cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			} else {
				double cv$probabilitySample34Value4 = distribution$sample34[var52];
				double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(cpu[0], cv$proposedValue, cpuVar[var52]));
				double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample34Value4), 0.0);
				if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
					cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
				else {
					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
						cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
					else
						cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
				}
			}
		}
		for(int i$var109 = 1; i$var109 < samples; i$var109 += 1) {
			if(fixedFlag$sample44) {
				if((var52 == st[i$var109])) {
					double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
					double cv$consumerDistributionProbabilityAccumulator = 1.0;
					int var84 = st[i$var109];
					if(((0 <= var84) && (var84 < noStates))) {
						cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(cpu[i$var109], cv$proposedValue, cpuVar[st[i$var109]]);
						cv$consumerDistributionProbabilityAccumulator = 0.0;
					}
					cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			} else {
				double cv$probabilitySample44Value13 = distribution$sample44[(i$var109 - 1)][var52];
				double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample44Value13) + DistributionSampling.logProbabilityGaussian(cpu[i$var109], cv$proposedValue, cpuVar[var52]));
				double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample44Value13), 0.0);
				if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
					cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
				else {
					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
						cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
					else
						cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
				}
			}
		}
		if((((cv$accumulatedProbabilities - cv$originalProbability) <= Math.log(DistributionSampling.sampleUniform(RNG$, 0.0, 1.0))) || Double.isNaN((cv$accumulatedProbabilities - cv$originalProbability))))
			cpuMean[var52] = cv$originalValue;
	}

	private final void sample68(int var63, int threadID$cv$var63, Rng RNG$) {
		double cv$originalValue = memMean[var63];
		double cv$originalProbability;
		double cv$var = ((cv$originalValue * cv$originalValue) * 0.010000000000000002);
		if((cv$var < 0.010000000000000002))
			cv$var = 0.010000000000000002;
		double cv$proposedValue = DistributionSampling.sampleGaussian(RNG$, cv$originalValue, cv$var);
		{
			double cv$accumulatedProbabilities = DistributionSampling.logProbabilityGaussian(cv$originalValue, 94.0, 1.0);
			if((0 < samples)) {
				if(fixedFlag$sample34) {
					if((var63 == st[0])) {
						double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
						double cv$consumerDistributionProbabilityAccumulator = 1.0;
						int var94 = st[0];
						if(((0 <= var94) && (var94 < noStates))) {
							cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(mem[0], cv$originalValue, memVar[st[0]]);
							cv$consumerDistributionProbabilityAccumulator = 0.0;
						}
						cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
						if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
							cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
						else {
							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
								cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
							else
								cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
						}
					}
				} else {
					double cv$probabilitySample34Value4 = distribution$sample34[var63];
					double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(mem[0], cv$originalValue, memVar[var63]));
					double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample34Value4), 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			}
			for(int i$var109 = 1; i$var109 < samples; i$var109 += 1) {
				if(fixedFlag$sample44) {
					if((var63 == st[i$var109])) {
						double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
						double cv$consumerDistributionProbabilityAccumulator = 1.0;
						int var94 = st[i$var109];
						if(((0 <= var94) && (var94 < noStates))) {
							cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(mem[i$var109], cv$originalValue, memVar[st[i$var109]]);
							cv$consumerDistributionProbabilityAccumulator = 0.0;
						}
						cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
						if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
							cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
						else {
							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
								cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
							else
								cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
						}
					}
				} else {
					double cv$probabilitySample44Value13 = distribution$sample44[(i$var109 - 1)][var63];
					double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample44Value13) + DistributionSampling.logProbabilityGaussian(mem[i$var109], cv$originalValue, memVar[var63]));
					double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample44Value13), 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			}
			cv$originalProbability = cv$accumulatedProbabilities;
		}
		memMean[var63] = cv$proposedValue;
		double cv$accumulatedProbabilities = DistributionSampling.logProbabilityGaussian(cv$proposedValue, 94.0, 1.0);
		if((0 < samples)) {
			if(fixedFlag$sample34) {
				if((var63 == st[0])) {
					double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
					double cv$consumerDistributionProbabilityAccumulator = 1.0;
					int var94 = st[0];
					if(((0 <= var94) && (var94 < noStates))) {
						cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(mem[0], cv$proposedValue, memVar[st[0]]);
						cv$consumerDistributionProbabilityAccumulator = 0.0;
					}
					cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			} else {
				double cv$probabilitySample34Value4 = distribution$sample34[var63];
				double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(mem[0], cv$proposedValue, memVar[var63]));
				double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample34Value4), 0.0);
				if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
					cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
				else {
					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
						cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
					else
						cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
				}
			}
		}
		for(int i$var109 = 1; i$var109 < samples; i$var109 += 1) {
			if(fixedFlag$sample44) {
				if((var63 == st[i$var109])) {
					double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
					double cv$consumerDistributionProbabilityAccumulator = 1.0;
					int var94 = st[i$var109];
					if(((0 <= var94) && (var94 < noStates))) {
						cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(mem[i$var109], cv$proposedValue, memVar[st[i$var109]]);
						cv$consumerDistributionProbabilityAccumulator = 0.0;
					}
					cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			} else {
				double cv$probabilitySample44Value13 = distribution$sample44[(i$var109 - 1)][var63];
				double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample44Value13) + DistributionSampling.logProbabilityGaussian(mem[i$var109], cv$proposedValue, memVar[var63]));
				double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample44Value13), 0.0);
				if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
					cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
				else {
					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
						cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
					else
						cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
				}
			}
		}
		if((((cv$accumulatedProbabilities - cv$originalProbability) <= Math.log(DistributionSampling.sampleUniform(RNG$, 0.0, 1.0))) || Double.isNaN((cv$accumulatedProbabilities - cv$originalProbability))))
			memMean[var63] = cv$originalValue;
	}

	private final void sample79(int var74, int threadID$cv$var74, Rng RNG$) {
		double cv$originalValue = pageFaultsMean[var74];
		double cv$originalProbability;
		double cv$var = ((cv$originalValue * cv$originalValue) * 0.010000000000000002);
		if((cv$var < 0.010000000000000002))
			cv$var = 0.010000000000000002;
		double cv$proposedValue = DistributionSampling.sampleGaussian(RNG$, cv$originalValue, cv$var);
		{
			double cv$accumulatedProbabilities = DistributionSampling.logProbabilityGaussian(cv$originalValue, 814.0, 335550.0);
			if((0 < samples)) {
				if(fixedFlag$sample34) {
					if((var74 == st[0])) {
						double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
						double cv$consumerDistributionProbabilityAccumulator = 1.0;
						int var104 = st[0];
						if(((0 <= var104) && (var104 < noStates))) {
							cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(pageFaults[0], cv$originalValue, pageFaultsVar[st[0]]);
							cv$consumerDistributionProbabilityAccumulator = 0.0;
						}
						cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
						if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
							cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
						else {
							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
								cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
							else
								cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
						}
					}
				} else {
					double cv$probabilitySample34Value4 = distribution$sample34[var74];
					double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(pageFaults[0], cv$originalValue, pageFaultsVar[var74]));
					double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample34Value4), 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			}
			for(int i$var109 = 1; i$var109 < samples; i$var109 += 1) {
				if(fixedFlag$sample44) {
					if((var74 == st[i$var109])) {
						double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
						double cv$consumerDistributionProbabilityAccumulator = 1.0;
						int var104 = st[i$var109];
						if(((0 <= var104) && (var104 < noStates))) {
							cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(pageFaults[i$var109], cv$originalValue, pageFaultsVar[st[i$var109]]);
							cv$consumerDistributionProbabilityAccumulator = 0.0;
						}
						cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
						if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
							cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
						else {
							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
								cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
							else
								cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
						}
					}
				} else {
					double cv$probabilitySample44Value13 = distribution$sample44[(i$var109 - 1)][var74];
					double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample44Value13) + DistributionSampling.logProbabilityGaussian(pageFaults[i$var109], cv$originalValue, pageFaultsVar[var74]));
					double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample44Value13), 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			}
			cv$originalProbability = cv$accumulatedProbabilities;
		}
		pageFaultsMean[var74] = cv$proposedValue;
		double cv$accumulatedProbabilities = DistributionSampling.logProbabilityGaussian(cv$proposedValue, 814.0, 335550.0);
		if((0 < samples)) {
			if(fixedFlag$sample34) {
				if((var74 == st[0])) {
					double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
					double cv$consumerDistributionProbabilityAccumulator = 1.0;
					int var104 = st[0];
					if(((0 <= var104) && (var104 < noStates))) {
						cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(pageFaults[0], cv$proposedValue, pageFaultsVar[st[0]]);
						cv$consumerDistributionProbabilityAccumulator = 0.0;
					}
					cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			} else {
				double cv$probabilitySample34Value4 = distribution$sample34[var74];
				double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(pageFaults[0], cv$proposedValue, pageFaultsVar[var74]));
				double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample34Value4), 0.0);
				if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
					cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
				else {
					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
						cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
					else
						cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
				}
			}
		}
		for(int i$var109 = 1; i$var109 < samples; i$var109 += 1) {
			if(fixedFlag$sample44) {
				if((var74 == st[i$var109])) {
					double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
					double cv$consumerDistributionProbabilityAccumulator = 1.0;
					int var104 = st[i$var109];
					if(((0 <= var104) && (var104 < noStates))) {
						cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(pageFaults[i$var109], cv$proposedValue, pageFaultsVar[st[i$var109]]);
						cv$consumerDistributionProbabilityAccumulator = 0.0;
					}
					cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			} else {
				double cv$probabilitySample44Value13 = distribution$sample44[(i$var109 - 1)][var74];
				double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample44Value13) + DistributionSampling.logProbabilityGaussian(pageFaults[i$var109], cv$proposedValue, pageFaultsVar[var74]));
				double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample44Value13), 0.0);
				if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
					cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
				else {
					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
						cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
					else
						cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
				}
			}
		}
		if((((cv$accumulatedProbabilities - cv$originalProbability) <= Math.log(DistributionSampling.sampleUniform(RNG$, 0.0, 1.0))) || Double.isNaN((cv$accumulatedProbabilities - cv$originalProbability))))
			pageFaultsMean[var74] = cv$originalValue;
	}

	private final void sample89(int var84, int threadID$cv$var84, Rng RNG$) {
		double cv$originalValue = cpuVar[var84];
		double cv$originalProbability;
		double cv$var = ((cv$originalValue * cv$originalValue) * 0.010000000000000002);
		if((cv$var < 0.010000000000000002))
			cv$var = 0.010000000000000002;
		double cv$proposedValue = DistributionSampling.sampleGaussian(RNG$, cv$originalValue, cv$var);
		{
			double cv$accumulatedProbabilities = DistributionSampling.logProbabilityInverseGamma(cv$originalValue, 5.0, 0.5);
			if((0 < samples)) {
				if(fixedFlag$sample34) {
					if((var84 == st[0])) {
						double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
						double cv$consumerDistributionProbabilityAccumulator = 1.0;
						int var52 = st[0];
						if(((0 <= var52) && (var52 < noStates))) {
							cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(cpu[0], cpuMean[st[0]], cv$originalValue);
							cv$consumerDistributionProbabilityAccumulator = 0.0;
						}
						cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
						if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
							cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
						else {
							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
								cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
							else
								cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
						}
					}
				} else {
					double cv$probabilitySample34Value4 = distribution$sample34[var84];
					double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(cpu[0], cpuMean[var84], cv$originalValue));
					double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample34Value4), 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			}
			for(int i$var109 = 1; i$var109 < samples; i$var109 += 1) {
				if(fixedFlag$sample44) {
					if((var84 == st[i$var109])) {
						double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
						double cv$consumerDistributionProbabilityAccumulator = 1.0;
						int var52 = st[i$var109];
						if(((0 <= var52) && (var52 < noStates))) {
							cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(cpu[i$var109], cpuMean[st[i$var109]], cv$originalValue);
							cv$consumerDistributionProbabilityAccumulator = 0.0;
						}
						cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
						if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
							cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
						else {
							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
								cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
							else
								cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
						}
					}
				} else {
					double cv$probabilitySample44Value13 = distribution$sample44[(i$var109 - 1)][var84];
					double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample44Value13) + DistributionSampling.logProbabilityGaussian(cpu[i$var109], cpuMean[var84], cv$originalValue));
					double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample44Value13), 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			}
			cv$originalProbability = cv$accumulatedProbabilities;
		}
		cpuVar[var84] = cv$proposedValue;
		double cv$accumulatedProbabilities = DistributionSampling.logProbabilityInverseGamma(cv$proposedValue, 5.0, 0.5);
		if((0 < samples)) {
			if(fixedFlag$sample34) {
				if((var84 == st[0])) {
					double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
					double cv$consumerDistributionProbabilityAccumulator = 1.0;
					int var52 = st[0];
					if(((0 <= var52) && (var52 < noStates))) {
						cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(cpu[0], cpuMean[st[0]], cv$proposedValue);
						cv$consumerDistributionProbabilityAccumulator = 0.0;
					}
					cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			} else {
				double cv$probabilitySample34Value4 = distribution$sample34[var84];
				double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(cpu[0], cpuMean[var84], cv$proposedValue));
				double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample34Value4), 0.0);
				if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
					cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
				else {
					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
						cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
					else
						cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
				}
			}
		}
		for(int i$var109 = 1; i$var109 < samples; i$var109 += 1) {
			if(fixedFlag$sample44) {
				if((var84 == st[i$var109])) {
					double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
					double cv$consumerDistributionProbabilityAccumulator = 1.0;
					int var52 = st[i$var109];
					if(((0 <= var52) && (var52 < noStates))) {
						cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(cpu[i$var109], cpuMean[st[i$var109]], cv$proposedValue);
						cv$consumerDistributionProbabilityAccumulator = 0.0;
					}
					cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			} else {
				double cv$probabilitySample44Value13 = distribution$sample44[(i$var109 - 1)][var84];
				double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample44Value13) + DistributionSampling.logProbabilityGaussian(cpu[i$var109], cpuMean[var84], cv$proposedValue));
				double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample44Value13), 0.0);
				if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
					cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
				else {
					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
						cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
					else
						cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
				}
			}
		}
		if((((cv$accumulatedProbabilities - cv$originalProbability) <= Math.log(DistributionSampling.sampleUniform(RNG$, 0.0, 1.0))) || Double.isNaN((cv$accumulatedProbabilities - cv$originalProbability))))
			cpuVar[var84] = cv$originalValue;
	}

	private final void sample99(int var94, int threadID$cv$var94, Rng RNG$) {
		double cv$originalValue = memVar[var94];
		double cv$originalProbability;
		double cv$var = ((cv$originalValue * cv$originalValue) * 0.010000000000000002);
		if((cv$var < 0.010000000000000002))
			cv$var = 0.010000000000000002;
		double cv$proposedValue = DistributionSampling.sampleGaussian(RNG$, cv$originalValue, cv$var);
		{
			double cv$accumulatedProbabilities = DistributionSampling.logProbabilityInverseGamma(cv$originalValue, 5.0, 0.5);
			if((0 < samples)) {
				if(fixedFlag$sample34) {
					if((var94 == st[0])) {
						double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
						double cv$consumerDistributionProbabilityAccumulator = 1.0;
						int var63 = st[0];
						if(((0 <= var63) && (var63 < noStates))) {
							cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(mem[0], memMean[st[0]], cv$originalValue);
							cv$consumerDistributionProbabilityAccumulator = 0.0;
						}
						cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
						if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
							cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
						else {
							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
								cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
							else
								cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
						}
					}
				} else {
					double cv$probabilitySample34Value4 = distribution$sample34[var94];
					double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(mem[0], memMean[var94], cv$originalValue));
					double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample34Value4), 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			}
			for(int i$var109 = 1; i$var109 < samples; i$var109 += 1) {
				if(fixedFlag$sample44) {
					if((var94 == st[i$var109])) {
						double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
						double cv$consumerDistributionProbabilityAccumulator = 1.0;
						int var63 = st[i$var109];
						if(((0 <= var63) && (var63 < noStates))) {
							cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(mem[i$var109], memMean[st[i$var109]], cv$originalValue);
							cv$consumerDistributionProbabilityAccumulator = 0.0;
						}
						cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
						if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
							cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
						else {
							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
								cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
							else
								cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
						}
					}
				} else {
					double cv$probabilitySample44Value13 = distribution$sample44[(i$var109 - 1)][var94];
					double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample44Value13) + DistributionSampling.logProbabilityGaussian(mem[i$var109], memMean[var94], cv$originalValue));
					double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample44Value13), 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			}
			cv$originalProbability = cv$accumulatedProbabilities;
		}
		memVar[var94] = cv$proposedValue;
		double cv$accumulatedProbabilities = DistributionSampling.logProbabilityInverseGamma(cv$proposedValue, 5.0, 0.5);
		if((0 < samples)) {
			if(fixedFlag$sample34) {
				if((var94 == st[0])) {
					double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
					double cv$consumerDistributionProbabilityAccumulator = 1.0;
					int var63 = st[0];
					if(((0 <= var63) && (var63 < noStates))) {
						cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(mem[0], memMean[st[0]], cv$proposedValue);
						cv$consumerDistributionProbabilityAccumulator = 0.0;
					}
					cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			} else {
				double cv$probabilitySample34Value4 = distribution$sample34[var94];
				double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample34Value4) + DistributionSampling.logProbabilityGaussian(mem[0], memMean[var94], cv$proposedValue));
				double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample34Value4), 0.0);
				if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
					cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
				else {
					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
						cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
					else
						cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
				}
			}
		}
		for(int i$var109 = 1; i$var109 < samples; i$var109 += 1) {
			if(fixedFlag$sample44) {
				if((var94 == st[i$var109])) {
					double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
					double cv$consumerDistributionProbabilityAccumulator = 1.0;
					int var63 = st[i$var109];
					if(((0 <= var63) && (var63 < noStates))) {
						cv$accumulatedConsumerProbabilities = DistributionSampling.logProbabilityGaussian(mem[i$var109], memMean[st[i$var109]], cv$proposedValue);
						cv$consumerDistributionProbabilityAccumulator = 0.0;
					}
					cv$consumerDistributionProbabilityAccumulator = Math.max(cv$consumerDistributionProbabilityAccumulator, 0.0);
					if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
						cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
					else {
						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
							cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
						else
							cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
					}
				}
			} else {
				double cv$probabilitySample44Value13 = distribution$sample44[(i$var109 - 1)][var94];
				double cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample44Value13) + DistributionSampling.logProbabilityGaussian(mem[i$var109], memMean[var94], cv$proposedValue));
				double cv$consumerDistributionProbabilityAccumulator = Math.max((1.0 - cv$probabilitySample44Value13), 0.0);
				if((Math.log(cv$consumerDistributionProbabilityAccumulator) < cv$accumulatedConsumerProbabilities))
					cv$accumulatedProbabilities = ((Math.log((Math.exp((Math.log(cv$consumerDistributionProbabilityAccumulator) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities) + cv$accumulatedProbabilities);
				else {
					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
						cv$accumulatedProbabilities = (Math.log(cv$consumerDistributionProbabilityAccumulator) + cv$accumulatedProbabilities);
					else
						cv$accumulatedProbabilities = ((Math.log((Math.exp((cv$accumulatedConsumerProbabilities - Math.log(cv$consumerDistributionProbabilityAccumulator))) + 1)) + Math.log(cv$consumerDistributionProbabilityAccumulator)) + cv$accumulatedProbabilities);
				}
			}
		}
		if((((cv$accumulatedProbabilities - cv$originalProbability) <= Math.log(DistributionSampling.sampleUniform(RNG$, 0.0, 1.0))) || Double.isNaN((cv$accumulatedProbabilities - cv$originalProbability))))
			memVar[var94] = cv$originalValue;
	}

	@Override
	public final void allocateScratch() {
		int cv$max = 0;
		if((0 < noStates))
			cv$max = noStates;
		int cv$threadCount = threadCount();
		cv$var22$countGlobal = new double[cv$threadCount][];
		for(int cv$index = 0; cv$index < cv$threadCount; cv$index += 1)
			cv$var22$countGlobal[cv$index] = new double[cv$max];
		cv$var27$countGlobal = new double[Math.max(0, noStates)];
		cv$distributionAccumulator$var39 = new double[noStates];
		cv$var30$stateProbabilityGlobal = new double[noStates];
		guard$sample34gaussian117$global = new boolean[length$cpu_measured];
		guard$sample34gaussian122$global = new boolean[length$cpu_measured];
		guard$sample34gaussian127$global = new boolean[length$cpu_measured];
		cv$var40$stateProbabilityGlobal = new double[noStates];
		guard$sample44gaussian117$global = new boolean[length$cpu_measured];
		guard$sample44gaussian122$global = new boolean[length$cpu_measured];
		guard$sample44gaussian127$global = new boolean[length$cpu_measured];
	}

	@Override
	public final void allocator() {
		v = new double[noStates];
		if(!setFlag$m) {
			m = new double[noStates][];
			for(int var21 = 0; var21 < noStates; var21 += 1)
				m[var21] = new double[noStates];
		}
		if(!setFlag$st)
			st = new int[length$cpu_measured];
		if(!setFlag$initialStateDistribution)
			initialStateDistribution = new double[noStates];
		if(!setFlag$cpu)
			cpu = new double[length$cpu_measured];
		if(!setFlag$mem)
			mem = new double[length$cpu_measured];
		if(!setFlag$pageFaults)
			pageFaults = new double[length$cpu_measured];
		if(!setFlag$cpuMean)
			cpuMean = new double[noStates];
		if(!setFlag$memMean)
			memMean = new double[noStates];
		if(!setFlag$pageFaultsMean)
			pageFaultsMean = new double[noStates];
		if(!setFlag$cpuVar)
			cpuVar = new double[noStates];
		if(!setFlag$memVar)
			memVar = new double[noStates];
		if(!setFlag$pageFaultsVar)
			pageFaultsVar = new double[noStates];
		distribution$sample34 = new double[noStates];
		distribution$sample44 = new double[(length$cpu_measured - 1)][];
		for(int i$var34 = 1; i$var34 < length$cpu_measured; i$var34 += 1)
			distribution$sample44[(i$var34 - 1)] = new double[noStates];
		logProbability$var39 = new double[(length$cpu_measured - 1)];
		logProbability$sample44 = new double[(length$cpu_measured - 1)];
		logProbability$var113 = new double[length$cpu_measured];
		logProbability$sample118 = new double[length$cpu_measured];
		logProbability$var118 = new double[length$cpu_measured];
		logProbability$sample123 = new double[length$cpu_measured];
		logProbability$var123 = new double[length$cpu_measured];
		logProbability$sample128 = new double[length$cpu_measured];
		allocateScratch();
	}

	@Override
	public final void forwardGeneration() {
		if(!fixedFlag$sample25)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var21, int forEnd$var21, int threadID$var21, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var21 = forStart$var21; var21 < forEnd$var21; var21 += 1)
							DistributionSampling.sampleDirichlet(RNG$1, v, m[var21]);
				}
			);

		if(!fixedFlag$sample31)
			DistributionSampling.sampleDirichlet(RNG$, v, initialStateDistribution);
		if(!fixedFlag$sample34)
			st[0] = DistributionSampling.sampleCategorical(RNG$, initialStateDistribution);
		if(!fixedFlag$sample44) {
			for(int i$var34 = 1; i$var34 < samples; i$var34 += 1)
				st[i$var34] = DistributionSampling.sampleCategorical(RNG$, m[st[(i$var34 - 1)]]);
		}
		if(!fixedFlag$sample57)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var52, int forEnd$var52, int threadID$var52, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var52 = forStart$var52; var52 < forEnd$var52; var52 += 1)
							cpuMean[var52] = DistributionSampling.sampleGaussian(RNG$1, 16.0, 8.6);
				}
			);

		if(!fixedFlag$sample68)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var63, int forEnd$var63, int threadID$var63, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var63 = forStart$var63; var63 < forEnd$var63; var63 += 1)
							memMean[var63] = DistributionSampling.sampleGaussian(RNG$1, 94.0, 1.0);
				}
			);

		if(!fixedFlag$sample79)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var74, int forEnd$var74, int threadID$var74, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var74 = forStart$var74; var74 < forEnd$var74; var74 += 1)
							pageFaultsMean[var74] = DistributionSampling.sampleGaussian(RNG$1, 814.0, 335550.0);
				}
			);

		if(!fixedFlag$sample89)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var84, int forEnd$var84, int threadID$var84, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var84 = forStart$var84; var84 < forEnd$var84; var84 += 1)
							cpuVar[var84] = DistributionSampling.sampleInverseGamma(RNG$1, 5.0, 0.5);
				}
			);

		if(!fixedFlag$sample99)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var94, int forEnd$var94, int threadID$var94, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var94 = forStart$var94; var94 < forEnd$var94; var94 += 1)
							memVar[var94] = DistributionSampling.sampleInverseGamma(RNG$1, 5.0, 0.5);
				}
			);

		if(!fixedFlag$sample109)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var104, int forEnd$var104, int threadID$var104, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var104 = forStart$var104; var104 < forEnd$var104; var104 += 1)
							pageFaultsVar[var104] = DistributionSampling.sampleInverseGamma(RNG$1, 5.0, 0.5);
				}
			);

		parallelFor(RNG$, 0, samples, 1,
			(int forStart$i$var109, int forEnd$i$var109, int threadID$i$var109, org.sandwood.random.internal.Rng RNG$1) -> { 
				for(int i$var109 = forStart$i$var109; i$var109 < forEnd$i$var109; i$var109 += 1) {
						if(!fixedFlag$sample118)
							cpu[i$var109] = DistributionSampling.sampleGaussian(RNG$1, cpuMean[st[i$var109]], cpuVar[st[i$var109]]);
						if(!fixedFlag$sample123)
							mem[i$var109] = DistributionSampling.sampleGaussian(RNG$1, memMean[st[i$var109]], memVar[st[i$var109]]);
						if(!fixedFlag$sample128)
							pageFaults[i$var109] = DistributionSampling.sampleGaussian(RNG$1, pageFaultsMean[st[i$var109]], pageFaultsVar[st[i$var109]]);
					}
			}
		);
	}

	@Override
	public final void forwardGenerationDistributionsNoOutputs() {
		if(!fixedFlag$sample25)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var21, int forEnd$var21, int threadID$var21, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var21 = forStart$var21; var21 < forEnd$var21; var21 += 1)
							DistributionSampling.sampleDirichlet(RNG$1, v, m[var21]);
				}
			);

		if(!fixedFlag$sample31)
			DistributionSampling.sampleDirichlet(RNG$, v, initialStateDistribution);
		if(!fixedFlag$sample34) {
			for(int index$var29 = 0; index$var29 < noStates; index$var29 += 1)
				distribution$sample34[index$var29] = DistributionSampling.probabilityCategorical(index$var29, initialStateDistribution);
		}
		if(!fixedFlag$sample44) {
			for(int i$var34 = 1; i$var34 < samples; i$var34 += 1) {
				double[] cv$distribution$sample44 = distribution$sample44[(i$var34 - 1)];
				for(int index$var39 = 0; index$var39 < noStates; index$var39 += 1)
					cv$distribution$sample44[index$var39] = 0.0;
				if((1 == i$var34)) {
					if(fixedFlag$sample34) {
						int var21 = st[0];
						if(((0 <= var21) && (var21 < noStates))) {
							double[] var38 = m[st[0]];
							for(int index$var39 = 0; index$var39 < noStates; index$var39 += 1)
								cv$distribution$sample44[index$var39] = (cv$distribution$sample44[index$var39] + DistributionSampling.probabilityCategorical(index$var39, var38));
						}
					} else {
						for(int index$sample34$2 = 0; index$sample34$2 < noStates; index$sample34$2 += 1) {
							double cv$probabilitySample34Value3 = distribution$sample34[index$sample34$2];
							double[] var38 = m[index$sample34$2];
							for(int index$var39 = 0; index$var39 < noStates; index$var39 += 1)
								cv$distribution$sample44[index$var39] = (cv$distribution$sample44[index$var39] + (cv$probabilitySample34Value3 * DistributionSampling.probabilityCategorical(index$var39, var38)));
						}
					}
				}
				int index$i$9 = (i$var34 - 1);
				if((1 <= index$i$9)) {
					for(int index$sample44$10 = 0; index$sample44$10 < noStates; index$sample44$10 += 1) {
						double cv$probabilitySample44Value11 = distribution$sample44[(index$i$9 - 1)][index$sample44$10];
						double[] var38 = m[index$sample44$10];
						for(int index$var39 = 0; index$var39 < noStates; index$var39 += 1)
							cv$distribution$sample44[index$var39] = (cv$distribution$sample44[index$var39] + (cv$probabilitySample44Value11 * DistributionSampling.probabilityCategorical(index$var39, var38)));
					}
				}
				double cv$var39$sum = 0.0;
				for(int index$var39 = 0; index$var39 < noStates; index$var39 += 1)
					cv$var39$sum = (cv$var39$sum + cv$distribution$sample44[index$var39]);
				for(int index$var39 = 0; index$var39 < noStates; index$var39 += 1)
					cv$distribution$sample44[index$var39] = (cv$distribution$sample44[index$var39] / cv$var39$sum);
			}
		}
		if(!fixedFlag$sample57)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var52, int forEnd$var52, int threadID$var52, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var52 = forStart$var52; var52 < forEnd$var52; var52 += 1)
							cpuMean[var52] = DistributionSampling.sampleGaussian(RNG$1, 16.0, 8.6);
				}
			);

		if(!fixedFlag$sample68)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var63, int forEnd$var63, int threadID$var63, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var63 = forStart$var63; var63 < forEnd$var63; var63 += 1)
							memMean[var63] = DistributionSampling.sampleGaussian(RNG$1, 94.0, 1.0);
				}
			);

		if(!fixedFlag$sample79)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var74, int forEnd$var74, int threadID$var74, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var74 = forStart$var74; var74 < forEnd$var74; var74 += 1)
							pageFaultsMean[var74] = DistributionSampling.sampleGaussian(RNG$1, 814.0, 335550.0);
				}
			);

		if(!fixedFlag$sample89)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var84, int forEnd$var84, int threadID$var84, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var84 = forStart$var84; var84 < forEnd$var84; var84 += 1)
							cpuVar[var84] = DistributionSampling.sampleInverseGamma(RNG$1, 5.0, 0.5);
				}
			);

		if(!fixedFlag$sample99)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var94, int forEnd$var94, int threadID$var94, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var94 = forStart$var94; var94 < forEnd$var94; var94 += 1)
							memVar[var94] = DistributionSampling.sampleInverseGamma(RNG$1, 5.0, 0.5);
				}
			);

		if(!fixedFlag$sample109)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var104, int forEnd$var104, int threadID$var104, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var104 = forStart$var104; var104 < forEnd$var104; var104 += 1)
							pageFaultsVar[var104] = DistributionSampling.sampleInverseGamma(RNG$1, 5.0, 0.5);
				}
			);

	}

	@Override
	public final void forwardGenerationValuesNoOutputs() {
		if(!fixedFlag$sample25)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var21, int forEnd$var21, int threadID$var21, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var21 = forStart$var21; var21 < forEnd$var21; var21 += 1)
							DistributionSampling.sampleDirichlet(RNG$1, v, m[var21]);
				}
			);

		if(!fixedFlag$sample31)
			DistributionSampling.sampleDirichlet(RNG$, v, initialStateDistribution);
		if(!fixedFlag$sample34)
			st[0] = DistributionSampling.sampleCategorical(RNG$, initialStateDistribution);
		if(!fixedFlag$sample44) {
			for(int i$var34 = 1; i$var34 < samples; i$var34 += 1)
				st[i$var34] = DistributionSampling.sampleCategorical(RNG$, m[st[(i$var34 - 1)]]);
		}
		if(!fixedFlag$sample57)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var52, int forEnd$var52, int threadID$var52, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var52 = forStart$var52; var52 < forEnd$var52; var52 += 1)
							cpuMean[var52] = DistributionSampling.sampleGaussian(RNG$1, 16.0, 8.6);
				}
			);

		if(!fixedFlag$sample68)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var63, int forEnd$var63, int threadID$var63, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var63 = forStart$var63; var63 < forEnd$var63; var63 += 1)
							memMean[var63] = DistributionSampling.sampleGaussian(RNG$1, 94.0, 1.0);
				}
			);

		if(!fixedFlag$sample79)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var74, int forEnd$var74, int threadID$var74, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var74 = forStart$var74; var74 < forEnd$var74; var74 += 1)
							pageFaultsMean[var74] = DistributionSampling.sampleGaussian(RNG$1, 814.0, 335550.0);
				}
			);

		if(!fixedFlag$sample89)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var84, int forEnd$var84, int threadID$var84, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var84 = forStart$var84; var84 < forEnd$var84; var84 += 1)
							cpuVar[var84] = DistributionSampling.sampleInverseGamma(RNG$1, 5.0, 0.5);
				}
			);

		if(!fixedFlag$sample99)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var94, int forEnd$var94, int threadID$var94, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var94 = forStart$var94; var94 < forEnd$var94; var94 += 1)
							memVar[var94] = DistributionSampling.sampleInverseGamma(RNG$1, 5.0, 0.5);
				}
			);

		if(!fixedFlag$sample109)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var104, int forEnd$var104, int threadID$var104, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var104 = forStart$var104; var104 < forEnd$var104; var104 += 1)
							pageFaultsVar[var104] = DistributionSampling.sampleInverseGamma(RNG$1, 5.0, 0.5);
				}
			);

	}

	@Override
	public final void gibbsRound() {
		if(system$gibbsForward) {
			if(!fixedFlag$sample25)
				parallelFor(RNG$, 0, noStates, 1,
					(int forStart$var21, int forEnd$var21, int threadID$var21, org.sandwood.random.internal.Rng RNG$1) -> { 
						for(int var21 = forStart$var21; var21 < forEnd$var21; var21 += 1)
								sample25(var21, threadID$var21, RNG$1);
					}
				);

			if(!fixedFlag$sample31)
				sample31();
			if(!fixedFlag$sample34)
				sample34();
			if(!fixedFlag$sample44) {
				for(int i$var34 = 1; i$var34 < samples; i$var34 += 1)
					sample44(i$var34);
			}
			if(!fixedFlag$sample57)
				parallelFor(RNG$, 0, noStates, 1,
					(int forStart$var52, int forEnd$var52, int threadID$var52, org.sandwood.random.internal.Rng RNG$1) -> { 
						for(int var52 = forStart$var52; var52 < forEnd$var52; var52 += 1)
								sample57(var52, threadID$var52, RNG$1);
					}
				);

			if(!fixedFlag$sample68)
				parallelFor(RNG$, 0, noStates, 1,
					(int forStart$var63, int forEnd$var63, int threadID$var63, org.sandwood.random.internal.Rng RNG$1) -> { 
						for(int var63 = forStart$var63; var63 < forEnd$var63; var63 += 1)
								sample68(var63, threadID$var63, RNG$1);
					}
				);

			if(!fixedFlag$sample79)
				parallelFor(RNG$, 0, noStates, 1,
					(int forStart$var74, int forEnd$var74, int threadID$var74, org.sandwood.random.internal.Rng RNG$1) -> { 
						for(int var74 = forStart$var74; var74 < forEnd$var74; var74 += 1)
								sample79(var74, threadID$var74, RNG$1);
					}
				);

			if(!fixedFlag$sample89)
				parallelFor(RNG$, 0, noStates, 1,
					(int forStart$var84, int forEnd$var84, int threadID$var84, org.sandwood.random.internal.Rng RNG$1) -> { 
						for(int var84 = forStart$var84; var84 < forEnd$var84; var84 += 1)
								sample89(var84, threadID$var84, RNG$1);
					}
				);

			if(!fixedFlag$sample99)
				parallelFor(RNG$, 0, noStates, 1,
					(int forStart$var94, int forEnd$var94, int threadID$var94, org.sandwood.random.internal.Rng RNG$1) -> { 
						for(int var94 = forStart$var94; var94 < forEnd$var94; var94 += 1)
								sample99(var94, threadID$var94, RNG$1);
					}
				);

			if(!fixedFlag$sample109)
				parallelFor(RNG$, 0, noStates, 1,
					(int forStart$var104, int forEnd$var104, int threadID$var104, org.sandwood.random.internal.Rng RNG$1) -> { 
						for(int var104 = forStart$var104; var104 < forEnd$var104; var104 += 1)
								sample109(var104, threadID$var104, RNG$1);
					}
				);

		} else {
			if(!fixedFlag$sample109)
				parallelFor(RNG$, 0, noStates, 1,
					(int forStart$var104, int forEnd$var104, int threadID$var104, org.sandwood.random.internal.Rng RNG$1) -> { 
						for(int var104 = forStart$var104; var104 < forEnd$var104; var104 += 1)
								sample109(var104, threadID$var104, RNG$1);
					}
				);

			if(!fixedFlag$sample99)
				parallelFor(RNG$, 0, noStates, 1,
					(int forStart$var94, int forEnd$var94, int threadID$var94, org.sandwood.random.internal.Rng RNG$1) -> { 
						for(int var94 = forStart$var94; var94 < forEnd$var94; var94 += 1)
								sample99(var94, threadID$var94, RNG$1);
					}
				);

			if(!fixedFlag$sample89)
				parallelFor(RNG$, 0, noStates, 1,
					(int forStart$var84, int forEnd$var84, int threadID$var84, org.sandwood.random.internal.Rng RNG$1) -> { 
						for(int var84 = forStart$var84; var84 < forEnd$var84; var84 += 1)
								sample89(var84, threadID$var84, RNG$1);
					}
				);

			if(!fixedFlag$sample79)
				parallelFor(RNG$, 0, noStates, 1,
					(int forStart$var74, int forEnd$var74, int threadID$var74, org.sandwood.random.internal.Rng RNG$1) -> { 
						for(int var74 = forStart$var74; var74 < forEnd$var74; var74 += 1)
								sample79(var74, threadID$var74, RNG$1);
					}
				);

			if(!fixedFlag$sample68)
				parallelFor(RNG$, 0, noStates, 1,
					(int forStart$var63, int forEnd$var63, int threadID$var63, org.sandwood.random.internal.Rng RNG$1) -> { 
						for(int var63 = forStart$var63; var63 < forEnd$var63; var63 += 1)
								sample68(var63, threadID$var63, RNG$1);
					}
				);

			if(!fixedFlag$sample57)
				parallelFor(RNG$, 0, noStates, 1,
					(int forStart$var52, int forEnd$var52, int threadID$var52, org.sandwood.random.internal.Rng RNG$1) -> { 
						for(int var52 = forStart$var52; var52 < forEnd$var52; var52 += 1)
								sample57(var52, threadID$var52, RNG$1);
					}
				);

			if(!fixedFlag$sample44) {
				for(int i$var34 = (samples - 1); i$var34 >= 1; i$var34 -= 1)
					sample44(i$var34);
			}
			if(!fixedFlag$sample34)
				sample34();
			if(!fixedFlag$sample31)
				sample31();
			if(!fixedFlag$sample25)
				parallelFor(RNG$, 0, noStates, 1,
					(int forStart$var21, int forEnd$var21, int threadID$var21, org.sandwood.random.internal.Rng RNG$1) -> { 
						for(int var21 = forStart$var21; var21 < forEnd$var21; var21 += 1)
								sample25(var21, threadID$var21, RNG$1);
					}
				);

		}
		system$gibbsForward = !system$gibbsForward;
	}

	@Override
	public final void initializeConstants() {
		parallelFor(RNG$, 0, noStates, 1,
			(int forStart$var14, int forEnd$var14, int threadID$var14, org.sandwood.random.internal.Rng RNG$1) -> { 
				for(int var14 = forStart$var14; var14 < forEnd$var14; var14 += 1)
						v[var14] = 0.1;
			}
		);
		samples = length$cpu_measured;
	}

	private final void initializeLogProbabilityFields() {
		logProbability$$model = 0.0;
		logProbability$$evidence = 0.0;
		logProbability$var17 = 0.0;
		logProbability$m = 0.0;
		if(!fixedProbFlag$sample25)
			logProbability$var22 = 0.0;
		logProbability$var26 = 0.0;
		if(!fixedProbFlag$sample31)
			logProbability$initialStateDistribution = 0.0;
		logProbability$var29 = 0.0;
		logProbability$st = 0.0;
		if(!fixedProbFlag$sample34)
			logProbability$var30 = 0.0;
		for(int i$var34 = 1; i$var34 < samples; i$var34 += 1)
			logProbability$var39[(i$var34 - 1)] = 0.0;
		if(!fixedProbFlag$sample44) {
			for(int i$var34 = 1; i$var34 < samples; i$var34 += 1)
				logProbability$sample44[(i$var34 - 1)] = 0.0;
		}
		logProbability$var48 = 0.0;
		logProbability$cpuMean = 0.0;
		if(!fixedProbFlag$sample57)
			logProbability$var53 = 0.0;
		logProbability$var59 = 0.0;
		logProbability$memMean = 0.0;
		if(!fixedProbFlag$sample68)
			logProbability$var64 = 0.0;
		logProbability$var70 = 0.0;
		logProbability$pageFaultsMean = 0.0;
		if(!fixedProbFlag$sample79)
			logProbability$var75 = 0.0;
		logProbability$var80 = 0.0;
		logProbability$cpuVar = 0.0;
		if(!fixedProbFlag$sample89)
			logProbability$var85 = 0.0;
		logProbability$var90 = 0.0;
		logProbability$memVar = 0.0;
		if(!fixedProbFlag$sample99)
			logProbability$var95 = 0.0;
		logProbability$var100 = 0.0;
		logProbability$pageFaultsVar = 0.0;
		if(!fixedProbFlag$sample109)
			logProbability$var105 = 0.0;
		for(int i$var109 = 0; i$var109 < samples; i$var109 += 1)
			logProbability$var113[i$var109] = 0.0;
		logProbability$cpu = 0.0;
		if(!fixedProbFlag$sample118) {
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1)
				logProbability$sample118[i$var109] = 0.0;
		}
		for(int i$var109 = 0; i$var109 < samples; i$var109 += 1)
			logProbability$var118[i$var109] = 0.0;
		logProbability$mem = 0.0;
		if(!fixedProbFlag$sample123) {
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1)
				logProbability$sample123[i$var109] = 0.0;
		}
		for(int i$var109 = 0; i$var109 < samples; i$var109 += 1)
			logProbability$var123[i$var109] = 0.0;
		logProbability$pageFaults = 0.0;
		if(!fixedProbFlag$sample128) {
			for(int i$var109 = 0; i$var109 < samples; i$var109 += 1)
				logProbability$sample128[i$var109] = 0.0;
		}
	}

	@Override
	public final void logEvidenceGeneration() {
		forwardGenerationValuesNoOutputs();
		logEvidenceProbabilities();
	}

	private final void logEvidenceProbabilities() {
		initializeLogProbabilityFields();
		if(fixedFlag$sample25)
			logProbabilityValue$sample25();
		if(fixedFlag$sample31)
			logProbabilityValue$sample31();
		if(fixedFlag$sample57)
			logProbabilityValue$sample57();
		if(fixedFlag$sample68)
			logProbabilityValue$sample68();
		if(fixedFlag$sample79)
			logProbabilityValue$sample79();
		if(fixedFlag$sample89)
			logProbabilityValue$sample89();
		if(fixedFlag$sample99)
			logProbabilityValue$sample99();
		if(fixedFlag$sample109)
			logProbabilityValue$sample109();
		logProbabilityValue$sample118();
		logProbabilityValue$sample123();
		logProbabilityValue$sample128();
	}

	@Override
	public final void logModelProbabilitiesDist() {
		initializeLogProbabilityFields();
		logProbabilityValue$sample25();
		logProbabilityValue$sample31();
		logProbabilityDistribution$sample34();
		logProbabilityDistribution$sample44();
		logProbabilityValue$sample57();
		logProbabilityValue$sample68();
		logProbabilityValue$sample79();
		logProbabilityValue$sample89();
		logProbabilityValue$sample99();
		logProbabilityValue$sample109();
		logProbabilityDistribution$sample118();
		logProbabilityDistribution$sample123();
		logProbabilityDistribution$sample128();
	}

	@Override
	public final void logModelProbabilitiesVal() {
		initializeLogProbabilityFields();
		logProbabilityValue$sample25();
		logProbabilityValue$sample31();
		logProbabilityValue$sample34();
		logProbabilityValue$sample44();
		logProbabilityValue$sample57();
		logProbabilityValue$sample68();
		logProbabilityValue$sample79();
		logProbabilityValue$sample89();
		logProbabilityValue$sample99();
		logProbabilityValue$sample109();
		logProbabilityValue$sample118();
		logProbabilityValue$sample123();
		logProbabilityValue$sample128();
	}

	@Override
	public final void logProbabilityGeneration() {
		if(!fixedFlag$sample25)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var21, int forEnd$var21, int threadID$var21, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var21 = forStart$var21; var21 < forEnd$var21; var21 += 1)
							DistributionSampling.sampleDirichlet(RNG$1, v, m[var21]);
				}
			);

		if(!fixedFlag$sample31)
			DistributionSampling.sampleDirichlet(RNG$, v, initialStateDistribution);
		if(!fixedFlag$sample34)
			st[0] = DistributionSampling.sampleCategorical(RNG$, initialStateDistribution);
		if(!fixedFlag$sample44) {
			for(int i$var34 = 1; i$var34 < samples; i$var34 += 1)
				st[i$var34] = DistributionSampling.sampleCategorical(RNG$, m[st[(i$var34 - 1)]]);
		}
		if(!fixedFlag$sample57)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var52, int forEnd$var52, int threadID$var52, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var52 = forStart$var52; var52 < forEnd$var52; var52 += 1)
							cpuMean[var52] = DistributionSampling.sampleGaussian(RNG$1, 16.0, 8.6);
				}
			);

		if(!fixedFlag$sample68)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var63, int forEnd$var63, int threadID$var63, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var63 = forStart$var63; var63 < forEnd$var63; var63 += 1)
							memMean[var63] = DistributionSampling.sampleGaussian(RNG$1, 94.0, 1.0);
				}
			);

		if(!fixedFlag$sample79)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var74, int forEnd$var74, int threadID$var74, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var74 = forStart$var74; var74 < forEnd$var74; var74 += 1)
							pageFaultsMean[var74] = DistributionSampling.sampleGaussian(RNG$1, 814.0, 335550.0);
				}
			);

		if(!fixedFlag$sample89)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var84, int forEnd$var84, int threadID$var84, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var84 = forStart$var84; var84 < forEnd$var84; var84 += 1)
							cpuVar[var84] = DistributionSampling.sampleInverseGamma(RNG$1, 5.0, 0.5);
				}
			);

		if(!fixedFlag$sample99)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var94, int forEnd$var94, int threadID$var94, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var94 = forStart$var94; var94 < forEnd$var94; var94 += 1)
							memVar[var94] = DistributionSampling.sampleInverseGamma(RNG$1, 5.0, 0.5);
				}
			);

		if(!fixedFlag$sample109)
			parallelFor(RNG$, 0, noStates, 1,
				(int forStart$var104, int forEnd$var104, int threadID$var104, org.sandwood.random.internal.Rng RNG$1) -> { 
					for(int var104 = forStart$var104; var104 < forEnd$var104; var104 += 1)
							pageFaultsVar[var104] = DistributionSampling.sampleInverseGamma(RNG$1, 5.0, 0.5);
				}
			);

		logModelProbabilitiesVal();
	}

	@Override
	public final void propogateObservedValues() {
		{
			int cv$length1 = pageFaults.length;
			for(int cv$index1 = 0; cv$index1 < cv$length1; cv$index1 += 1)
				pageFaults[cv$index1] = pageFaults_measured[cv$index1];
		}
		{
			int cv$length1 = mem.length;
			for(int cv$index1 = 0; cv$index1 < cv$length1; cv$index1 += 1)
				mem[cv$index1] = mem_measured[cv$index1];
		}
		int cv$length1 = cpu.length;
		for(int cv$index1 = 0; cv$index1 < cv$length1; cv$index1 += 1)
			cpu[cv$index1] = cpu_measured[cv$index1];
	}

	@Override
	public final void setIntermediates() {}

	@Override
	public String modelCode() {
		return "package org.sandwood.compiler.tests.parser;\n\nmodel HMMMetrics(double[] cpu_measured, double[] mem_measured, double[] pageFaults_measured, int noStates) {\n    \n    // Construct vectors describing the probability of a move from 1 state to another.\n    double[] v = new double[noStates] <~ 0.1;\n    double[][] m = dirichlet(v).sample(noStates);\n    \n    // Determine how many samples the model will need to produce.\n    int samples = cpu_measured.length;\n    \n    // Allocate space for the state.\n    int[] st = new int[samples];\n\n    // Set the initial state by sampling from a categorical with learnt weightings.\n    double[] initialStateDistribution = dirichlet(v).sample();\n    st[0] = categorical(initialStateDistribution).sampleDistribution();\n\n    //Determine the remaining states based on the previous state.\n    for(int i:[1 .. samples))\n        st[i] = categorical(m[st[i-1]]).sampleDistribution();\n        \n    //Generate each metric.\n    double[] cpu = new double[samples];\n    double[] mem = new double[samples];\n    double[] pageFaults = new double[samples];\n    \n    double[] cpuMean = gaussian(16, 8.6).sample(noStates);\n    double[] memMean = gaussian(94, 1).sample(noStates);\n    double[] pageFaultsMean = gaussian(814, 335550).sample(noStates);\n    \n    double[] cpuVar = inverseGamma(5, 0.5).sample(noStates);\n    double[] memVar = inverseGamma(5, 0.5).sample(noStates);\n    double[] pageFaultsVar = inverseGamma(5, 0.5).sample(noStates);\n    \n    for(int i:[0 .. samples)) {\n        int s = st[i];\n        cpu[i] = gaussian(cpuMean[s], cpuVar[s]).sample();\n        mem[i] = gaussian(memMean[s], memVar[s]).sample();\n        pageFaults[i] = gaussian(pageFaultsMean[s], pageFaultsVar[s]).sample();\n    }\n\n    //Tie the values to the values we have measured.\n    cpu.observe(cpu_measured);\n    mem.observe(mem_measured);\n    pageFaults.observe(pageFaults_measured);\n}\n";
	}
}