package org.sandwood.compiler.tests.parser;

import org.sandwood.runtime.internal.numericTools.DistributionSampling;
import org.sandwood.runtime.model.ExecutionTarget;

class DistributionTest4$MultiThreadCPU extends org.sandwood.runtime.internal.model.CoreModelMultiThreadCPU implements DistributionTest4$CoreInterface {
	private double[] cv$var15$stateProbabilityGlobal;
	private double[] cv$var23$stateProbabilityGlobal;
	private double[] cv$var9$stateProbabilityGlobal;
	private double[] distribution$sample12;
	private double[] distribution$sample18;
	private double[][] distribution$sample26;
	private boolean fixedFlag$sample12 = false;
	private boolean fixedFlag$sample18 = false;
	private boolean fixedFlag$sample26 = false;
	private boolean fixedFlag$sample45 = false;
	private boolean fixedProbFlag$sample12 = false;
	private boolean fixedProbFlag$sample18 = false;
	private boolean fixedProbFlag$sample26 = false;
	private boolean fixedProbFlag$sample45 = false;
	private boolean[] guard$sample18bernoulli44$global;
	private boolean[] guard$sample26bernoulli44$global;
	private int length$value;
	private double logProbability$$evidence;
	private double logProbability$$model;
	private double[] logProbability$sample26;
	private double[] logProbability$sample45;
	private double logProbability$v;
	private double logProbability$v1;
	private double logProbability$v2;
	private double logProbability$var14;
	private double logProbability$var15;
	private double[] logProbability$var22;
	private double[] logProbability$var41;
	private double logProbability$var8;
	private boolean setFlag$v = false;
	private boolean setFlag$v2 = false;
	private int size;
	private boolean system$gibbsForward = true;
	private boolean[] v;
	private int v1;
	private int[] v2;
	private boolean[] value;
	private double[] weightings;

	public DistributionTest4$MultiThreadCPU(ExecutionTarget target) {
		super(target);
	}

	@Override
	public final boolean get$fixedFlag$sample12() {
		return fixedFlag$sample12;
	}

	@Override
	public final void set$fixedFlag$sample12(boolean cv$value) {
		fixedFlag$sample12 = cv$value;
		fixedProbFlag$sample12 = (fixedFlag$sample12 && fixedProbFlag$sample12);
		fixedProbFlag$sample45 = (fixedFlag$sample12 && fixedProbFlag$sample45);
	}

	@Override
	public final boolean get$fixedFlag$sample18() {
		return fixedFlag$sample18;
	}

	@Override
	public final void set$fixedFlag$sample18(boolean cv$value) {
		fixedFlag$sample18 = cv$value;
		fixedProbFlag$sample18 = (fixedFlag$sample18 && fixedProbFlag$sample18);
		fixedProbFlag$sample45 = (fixedFlag$sample18 && fixedProbFlag$sample45);
	}

	@Override
	public final boolean get$fixedFlag$sample26() {
		return fixedFlag$sample26;
	}

	@Override
	public final void set$fixedFlag$sample26(boolean cv$value) {
		fixedFlag$sample26 = cv$value;
		fixedProbFlag$sample26 = (fixedFlag$sample26 && fixedProbFlag$sample26);
		fixedProbFlag$sample45 = (fixedFlag$sample26 && fixedProbFlag$sample45);
	}

	@Override
	public final boolean get$fixedFlag$sample45() {
		return fixedFlag$sample45;
	}

	@Override
	public final void set$fixedFlag$sample45(boolean cv$value) {
		fixedFlag$sample45 = cv$value;
		fixedProbFlag$sample45 = (fixedFlag$sample45 && fixedProbFlag$sample45);
	}

	@Override
	public final int get$length$value() {
		return length$value;
	}

	@Override
	public final void set$length$value(int cv$value) {
		length$value = cv$value;
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
	public final double get$logProbability$v() {
		return logProbability$v;
	}

	@Override
	public final double get$logProbability$v1() {
		return logProbability$v1;
	}

	@Override
	public final double get$logProbability$v2() {
		return logProbability$v2;
	}

	@Override
	public final int get$size() {
		return size;
	}

	@Override
	public final boolean[] get$v() {
		return v;
	}

	@Override
	public final void set$v(boolean[] cv$value) {
		v = cv$value;
		setFlag$v = true;
	}

	@Override
	public final int get$v1() {
		return v1;
	}

	@Override
	public final void set$v1(int cv$value) {
		v1 = cv$value;
	}

	@Override
	public final int[] get$v2() {
		return v2;
	}

	@Override
	public final void set$v2(int[] cv$value) {
		v2 = cv$value;
		setFlag$v2 = true;
	}

	@Override
	public final boolean[] get$value() {
		return value;
	}

	@Override
	public final void set$value(boolean[] cv$value) {
		value = cv$value;
	}

	@Override
	public final double[] get$weightings() {
		return weightings;
	}

	@Override
	public final void set$weightings(double[] cv$value) {
		weightings = cv$value;
	}

	private final void logProbabilityDistribution$sample12() {
		if(!fixedProbFlag$sample12) {
			if(fixedFlag$sample12) {
				double cv$accumulator = 0.0;
				double cv$sampleAccumulator = 0.0;
				double cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				double cv$probabilityReached = 0.0;
				{
					int cv$sampleValue = v1;
					{
						{
							double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityCategorical(cv$sampleValue, weightings));
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
				}
				if((cv$probabilityReached == 0.0))
					cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				else
					cv$distributionAccumulator = (cv$distributionAccumulator - Math.log(cv$probabilityReached));
				double cv$sampleProbability = cv$distributionAccumulator;
				cv$sampleAccumulator = (cv$sampleAccumulator + cv$sampleProbability);
				cv$accumulator = (cv$accumulator + cv$sampleAccumulator);
				logProbability$var8 = cv$sampleAccumulator;
				logProbability$v1 = cv$sampleProbability;
				logProbability$$model = (logProbability$$model + cv$accumulator);
				if(fixedFlag$sample12)
					logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
				fixedProbFlag$sample12 = fixedFlag$sample12;
			}
		} else {
			double cv$accumulator = 0.0;
			double cv$rvAccumulator = 0.0;
			double cv$sampleValue = logProbability$v1;
			cv$rvAccumulator = (cv$rvAccumulator + cv$sampleValue);
			cv$accumulator = (cv$accumulator + cv$rvAccumulator);
			logProbability$var8 = cv$rvAccumulator;
			logProbability$$model = (logProbability$$model + cv$accumulator);
			if(fixedFlag$sample12)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityDistribution$sample18() {
		if(!fixedProbFlag$sample18) {
			if(fixedFlag$sample18) {
				double cv$accumulator = 0.0;
				double cv$sampleAccumulator = 0.0;
				double cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				double cv$probabilityReached = 0.0;
				{
					int cv$sampleValue = v2[0];
					{
						{
							double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityCategorical(cv$sampleValue, weightings));
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
				}
				if((cv$probabilityReached == 0.0))
					cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				else
					cv$distributionAccumulator = (cv$distributionAccumulator - Math.log(cv$probabilityReached));
				double cv$sampleProbability = cv$distributionAccumulator;
				cv$sampleAccumulator = (cv$sampleAccumulator + cv$sampleProbability);
				cv$accumulator = (cv$accumulator + cv$sampleAccumulator);
				logProbability$var14 = cv$sampleAccumulator;
				logProbability$var15 = cv$sampleProbability;
				if(fixedFlag$sample18)
					logProbability$v2 = (logProbability$v2 + cv$accumulator);
				logProbability$$model = (logProbability$$model + cv$accumulator);
				if(fixedFlag$sample18)
					logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
				fixedProbFlag$sample18 = fixedFlag$sample18;
			}
		} else {
			double cv$accumulator = 0.0;
			double cv$rvAccumulator = 0.0;
			double cv$sampleValue = logProbability$var15;
			cv$rvAccumulator = (cv$rvAccumulator + cv$sampleValue);
			cv$accumulator = (cv$accumulator + cv$rvAccumulator);
			logProbability$var14 = cv$rvAccumulator;
			if(fixedFlag$sample18)
				logProbability$v2 = (logProbability$v2 + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			if(fixedFlag$sample18)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityDistribution$sample26() {
		if(!fixedProbFlag$sample26) {
			if(fixedFlag$sample26) {
				double cv$accumulator = 0.0;
				for(int i = 0; i < size; i += 1) {
					double cv$sampleAccumulator = 0.0;
					double cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
					double cv$probabilityReached = 0.0;
					int index$i$1 = i;
					{
						int cv$sampleValue = v2[(i + 1)];
						{
							{
								double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityCategorical(cv$sampleValue, weightings));
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
					}
					if((cv$probabilityReached == 0.0))
						cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
					else
						cv$distributionAccumulator = (cv$distributionAccumulator - Math.log(cv$probabilityReached));
					double cv$sampleProbability = cv$distributionAccumulator;
					cv$sampleAccumulator = (cv$sampleAccumulator + cv$sampleProbability);
					cv$accumulator = (cv$accumulator + cv$sampleAccumulator);
					logProbability$var22[((i - 0) / 1)] = cv$sampleAccumulator;
					logProbability$sample26[((i - 0) / 1)] = cv$sampleProbability;
				}
				if(fixedFlag$sample26)
					logProbability$v2 = (logProbability$v2 + cv$accumulator);
				logProbability$$model = (logProbability$$model + cv$accumulator);
				if(fixedFlag$sample26)
					logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
				fixedProbFlag$sample26 = fixedFlag$sample26;
			}
		} else {
			double cv$accumulator = 0.0;
			for(int i = 0; i < size; i += 1) {
				double cv$rvAccumulator = 0.0;
				double cv$sampleValue = logProbability$sample26[((i - 0) / 1)];
				cv$rvAccumulator = (cv$rvAccumulator + cv$sampleValue);
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var22[((i - 0) / 1)] = cv$rvAccumulator;
			}
			if(fixedFlag$sample26)
				logProbability$v2 = (logProbability$v2 + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			if(fixedFlag$sample26)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityDistribution$sample45() {
		if(!fixedProbFlag$sample45) {
			double cv$accumulator = 0.0;
			for(int j = 0; j < size; j += 1) {
				double cv$sampleAccumulator = 0.0;
				double cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				double cv$probabilityReached = 0.0;
				{
					boolean cv$sampleValue = v[j];
					if(fixedFlag$sample12) {
						if(fixedFlag$sample18) {
							if((0 == j)) {
								if((0 == (j + 1))) {
									if((0 == (j + 1))) {
										{
											double var40 = ((((1.0 * v1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
											double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
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
								}
							}
						} else {
							if(true) {
								for(int index$sample18$8 = 0; index$sample18$8 < weightings.length; index$sample18$8 += 1) {
									int distributionTempVariable$var15$10 = index$sample18$8;
									double cv$probabilitySample18Value9 = (1.0 * distribution$sample18[index$sample18$8]);
									int traceTempVariable$var31$11_1 = distributionTempVariable$var15$10;
									if((0 == j)) {
										int traceTempVariable$var35$18_1 = distributionTempVariable$var15$10;
										if((0 == (j + 1))) {
											int traceTempVariable$var39$30_1 = distributionTempVariable$var15$10;
											if((0 == (j + 1))) {
												{
													double var40 = ((((1.0 * v1) + traceTempVariable$var31$11_1) + traceTempVariable$var35$18_1) / traceTempVariable$var39$30_1);
													double cv$weightedProbability = (Math.log(cv$probabilitySample18Value9) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
													if((cv$weightedProbability < cv$distributionAccumulator))
														cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
													else {
														if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
															cv$distributionAccumulator = cv$weightedProbability;
														else
															cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
													}
													cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value9);
												}
											}
											if(!true) {
												for(int index$sample18$31 = 0; index$sample18$31 < weightings.length; index$sample18$31 += 1) {
													int distributionTempVariable$var15$33 = index$sample18$31;
													double cv$probabilitySample18Value32 = (cv$probabilitySample18Value9 * distribution$sample18[index$sample18$31]);
													int traceTempVariable$var39$34_1 = distributionTempVariable$var15$33;
													if((0 == (j + 1))) {
														{
															double var40 = ((((1.0 * v1) + traceTempVariable$var31$11_1) + traceTempVariable$var35$18_1) / traceTempVariable$var39$34_1);
															double cv$weightedProbability = (Math.log(cv$probabilitySample18Value32) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value32);
														}
													}
												}
											}
										}
										if(!true) {
											for(int index$sample18$19 = 0; index$sample18$19 < weightings.length; index$sample18$19 += 1) {
												int distributionTempVariable$var15$21 = index$sample18$19;
												double cv$probabilitySample18Value20 = (cv$probabilitySample18Value9 * distribution$sample18[index$sample18$19]);
												int traceTempVariable$var35$22_1 = distributionTempVariable$var15$21;
												if((0 == (j + 1))) {
													int traceTempVariable$var39$35_1 = distributionTempVariable$var15$10;
													if((0 == (j + 1))) {
														{
															double var40 = ((((1.0 * v1) + traceTempVariable$var31$11_1) + traceTempVariable$var35$22_1) / traceTempVariable$var39$35_1);
															double cv$weightedProbability = (Math.log(cv$probabilitySample18Value20) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value20);
														}
													}
													int traceTempVariable$var39$36_1 = distributionTempVariable$var15$21;
													if((0 == (j + 1))) {
														{
															double var40 = ((((1.0 * v1) + traceTempVariable$var31$11_1) + traceTempVariable$var35$22_1) / traceTempVariable$var39$36_1);
															double cv$weightedProbability = (Math.log(cv$probabilitySample18Value20) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value20);
														}
													}
													if(!true) {
														for(int index$sample18$37 = 0; index$sample18$37 < weightings.length; index$sample18$37 += 1) {
															int distributionTempVariable$var15$39 = index$sample18$37;
															double cv$probabilitySample18Value38 = (cv$probabilitySample18Value20 * distribution$sample18[index$sample18$37]);
															int traceTempVariable$var39$40_1 = distributionTempVariable$var15$39;
															if((0 == (j + 1))) {
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$11_1) + traceTempVariable$var35$22_1) / traceTempVariable$var39$40_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample18Value38) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value38);
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						if(true) {
							for(int index$sample12$3 = 0; index$sample12$3 < weightings.length; index$sample12$3 += 1) {
								int distributionTempVariable$v1$5 = index$sample12$3;
								double cv$probabilitySample12Value4 = (1.0 * distribution$sample12[index$sample12$3]);
								int traceTempVariable$v1$6_1 = distributionTempVariable$v1$5;
								if(fixedFlag$sample18) {
									if((0 == j)) {
										if((0 == (j + 1))) {
											if((0 == (j + 1))) {
												{
													double var40 = ((((1.0 * traceTempVariable$v1$6_1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
													double cv$weightedProbability = (Math.log(cv$probabilitySample12Value4) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
													if((cv$weightedProbability < cv$distributionAccumulator))
														cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
													else {
														if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
															cv$distributionAccumulator = cv$weightedProbability;
														else
															cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
													}
													cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample12Value4);
												}
											}
										}
									}
								} else {
									if(true) {
										for(int index$sample18$13 = 0; index$sample18$13 < weightings.length; index$sample18$13 += 1) {
											int distributionTempVariable$var15$15 = index$sample18$13;
											double cv$probabilitySample18Value14 = (cv$probabilitySample12Value4 * distribution$sample18[index$sample18$13]);
											int traceTempVariable$var31$16_1 = distributionTempVariable$var15$15;
											if((0 == j)) {
												int traceTempVariable$var35$24_1 = distributionTempVariable$var15$15;
												if((0 == (j + 1))) {
													int traceTempVariable$var39$42_1 = distributionTempVariable$var15$15;
													if((0 == (j + 1))) {
														{
															double var40 = ((((1.0 * traceTempVariable$v1$6_1) + traceTempVariable$var31$16_1) + traceTempVariable$var35$24_1) / traceTempVariable$var39$42_1);
															double cv$weightedProbability = (Math.log(cv$probabilitySample18Value14) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value14);
														}
													}
													if(!true) {
														for(int index$sample18$43 = 0; index$sample18$43 < weightings.length; index$sample18$43 += 1) {
															int distributionTempVariable$var15$45 = index$sample18$43;
															double cv$probabilitySample18Value44 = (cv$probabilitySample18Value14 * distribution$sample18[index$sample18$43]);
															int traceTempVariable$var39$46_1 = distributionTempVariable$var15$45;
															if((0 == (j + 1))) {
																{
																	double var40 = ((((1.0 * traceTempVariable$v1$6_1) + traceTempVariable$var31$16_1) + traceTempVariable$var35$24_1) / traceTempVariable$var39$46_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample18Value44) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value44);
																}
															}
														}
													}
												}
												if(!true) {
													for(int index$sample18$25 = 0; index$sample18$25 < weightings.length; index$sample18$25 += 1) {
														int distributionTempVariable$var15$27 = index$sample18$25;
														double cv$probabilitySample18Value26 = (cv$probabilitySample18Value14 * distribution$sample18[index$sample18$25]);
														int traceTempVariable$var35$28_1 = distributionTempVariable$var15$27;
														if((0 == (j + 1))) {
															int traceTempVariable$var39$47_1 = distributionTempVariable$var15$15;
															if((0 == (j + 1))) {
																{
																	double var40 = ((((1.0 * traceTempVariable$v1$6_1) + traceTempVariable$var31$16_1) + traceTempVariable$var35$28_1) / traceTempVariable$var39$47_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample18Value26) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value26);
																}
															}
															int traceTempVariable$var39$48_1 = distributionTempVariable$var15$27;
															if((0 == (j + 1))) {
																{
																	double var40 = ((((1.0 * traceTempVariable$v1$6_1) + traceTempVariable$var31$16_1) + traceTempVariable$var35$28_1) / traceTempVariable$var39$48_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample18Value26) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value26);
																}
															}
															if(!true) {
																for(int index$sample18$49 = 0; index$sample18$49 < weightings.length; index$sample18$49 += 1) {
																	int distributionTempVariable$var15$51 = index$sample18$49;
																	double cv$probabilitySample18Value50 = (cv$probabilitySample18Value26 * distribution$sample18[index$sample18$49]);
																	int traceTempVariable$var39$52_1 = distributionTempVariable$var15$51;
																	if((0 == (j + 1))) {
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$6_1) + traceTempVariable$var31$16_1) + traceTempVariable$var35$28_1) / traceTempVariable$var39$52_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample18Value50) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value50);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					if(fixedFlag$sample12) {
						if(fixedFlag$sample26) {
							for(int i = 0; i < size; i += 1) {
								if(((i + 1) == j)) {
									if(fixedFlag$sample18) {
										if((0 == (j + 1))) {
											if((0 == (j + 1))) {
												{
													double var40 = ((((1.0 * v1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
													double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
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
										}
									} else {
										if(true) {
											for(int index$sample18$71 = 0; index$sample18$71 < weightings.length; index$sample18$71 += 1) {
												int distributionTempVariable$var15$73 = index$sample18$71;
												double cv$probabilitySample18Value72 = (1.0 * distribution$sample18[index$sample18$71]);
												int traceTempVariable$var35$74_1 = distributionTempVariable$var15$73;
												if((0 == (j + 1))) {
													int traceTempVariable$var39$91_1 = distributionTempVariable$var15$73;
													if((0 == (j + 1))) {
														{
															double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$74_1) / traceTempVariable$var39$91_1);
															double cv$weightedProbability = (Math.log(cv$probabilitySample18Value72) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value72);
														}
													}
													if(!true) {
														for(int index$sample18$92 = 0; index$sample18$92 < weightings.length; index$sample18$92 += 1) {
															int distributionTempVariable$var15$94 = index$sample18$92;
															double cv$probabilitySample18Value93 = (cv$probabilitySample18Value72 * distribution$sample18[index$sample18$92]);
															int traceTempVariable$var39$95_1 = distributionTempVariable$var15$94;
															if((0 == (j + 1))) {
																{
																	double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$74_1) / traceTempVariable$var39$95_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample18Value93) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value93);
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						} else {
							for(int i = 0; i < size; i += 1) {
								if(true) {
									for(int index$sample26$60 = 0; index$sample26$60 < weightings.length; index$sample26$60 += 1) {
										int distributionTempVariable$var23$62 = index$sample26$60;
										double cv$probabilitySample26Value61 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$60]);
										int traceTempVariable$var31$63_1 = distributionTempVariable$var23$62;
										if(((i + 1) == j)) {
											if(fixedFlag$sample18) {
												if((0 == (j + 1))) {
													if((0 == (j + 1))) {
														{
															double var40 = ((((1.0 * v1) + traceTempVariable$var31$63_1) + v2[(j + 1)]) / v2[(j + 1)]);
															double cv$weightedProbability = (Math.log(cv$probabilitySample26Value61) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value61);
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample18$76 = 0; index$sample18$76 < weightings.length; index$sample18$76 += 1) {
														int distributionTempVariable$var15$78 = index$sample18$76;
														double cv$probabilitySample18Value77 = (cv$probabilitySample26Value61 * distribution$sample18[index$sample18$76]);
														int traceTempVariable$var35$79_1 = distributionTempVariable$var15$78;
														if((0 == (j + 1))) {
															int traceTempVariable$var39$97_1 = distributionTempVariable$var15$78;
															if((0 == (j + 1))) {
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$63_1) + traceTempVariable$var35$79_1) / traceTempVariable$var39$97_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample18Value77) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value77);
																}
															}
															if(!true) {
																for(int index$sample18$98 = 0; index$sample18$98 < weightings.length; index$sample18$98 += 1) {
																	int distributionTempVariable$var15$100 = index$sample18$98;
																	double cv$probabilitySample18Value99 = (cv$probabilitySample18Value77 * distribution$sample18[index$sample18$98]);
																	int traceTempVariable$var39$101_1 = distributionTempVariable$var15$100;
																	if((0 == (j + 1))) {
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$63_1) + traceTempVariable$var35$79_1) / traceTempVariable$var39$101_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample18Value99) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value99);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						if(true) {
							for(int index$sample12$54 = 0; index$sample12$54 < weightings.length; index$sample12$54 += 1) {
								int distributionTempVariable$v1$56 = index$sample12$54;
								double cv$probabilitySample12Value55 = (1.0 * distribution$sample12[index$sample12$54]);
								int traceTempVariable$v1$57_1 = distributionTempVariable$v1$56;
								if(fixedFlag$sample26) {
									for(int i = 0; i < size; i += 1) {
										if(((i + 1) == j)) {
											if(fixedFlag$sample18) {
												if((0 == (j + 1))) {
													if((0 == (j + 1))) {
														{
															double var40 = ((((1.0 * traceTempVariable$v1$57_1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
															double cv$weightedProbability = (Math.log(cv$probabilitySample12Value55) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample12Value55);
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample18$81 = 0; index$sample18$81 < weightings.length; index$sample18$81 += 1) {
														int distributionTempVariable$var15$83 = index$sample18$81;
														double cv$probabilitySample18Value82 = (cv$probabilitySample12Value55 * distribution$sample18[index$sample18$81]);
														int traceTempVariable$var35$84_1 = distributionTempVariable$var15$83;
														if((0 == (j + 1))) {
															int traceTempVariable$var39$103_1 = distributionTempVariable$var15$83;
															if((0 == (j + 1))) {
																{
																	double var40 = ((((1.0 * traceTempVariable$v1$57_1) + v2[j]) + traceTempVariable$var35$84_1) / traceTempVariable$var39$103_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample18Value82) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value82);
																}
															}
															if(!true) {
																for(int index$sample18$104 = 0; index$sample18$104 < weightings.length; index$sample18$104 += 1) {
																	int distributionTempVariable$var15$106 = index$sample18$104;
																	double cv$probabilitySample18Value105 = (cv$probabilitySample18Value82 * distribution$sample18[index$sample18$104]);
																	int traceTempVariable$var39$107_1 = distributionTempVariable$var15$106;
																	if((0 == (j + 1))) {
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$57_1) + v2[j]) + traceTempVariable$var35$84_1) / traceTempVariable$var39$107_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample18Value105) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value105);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								} else {
									for(int i = 0; i < size; i += 1) {
										if(true) {
											for(int index$sample26$66 = 0; index$sample26$66 < weightings.length; index$sample26$66 += 1) {
												int distributionTempVariable$var23$68 = index$sample26$66;
												double cv$probabilitySample26Value67 = (cv$probabilitySample12Value55 * distribution$sample26[((i - 0) / 1)][index$sample26$66]);
												int traceTempVariable$var31$69_1 = distributionTempVariable$var23$68;
												if(((i + 1) == j)) {
													if(fixedFlag$sample18) {
														if((0 == (j + 1))) {
															if((0 == (j + 1))) {
																{
																	double var40 = ((((1.0 * traceTempVariable$v1$57_1) + traceTempVariable$var31$69_1) + v2[(j + 1)]) / v2[(j + 1)]);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample26Value67) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value67);
																}
															}
														}
													} else {
														if(true) {
															for(int index$sample18$86 = 0; index$sample18$86 < weightings.length; index$sample18$86 += 1) {
																int distributionTempVariable$var15$88 = index$sample18$86;
																double cv$probabilitySample18Value87 = (cv$probabilitySample26Value67 * distribution$sample18[index$sample18$86]);
																int traceTempVariable$var35$89_1 = distributionTempVariable$var15$88;
																if((0 == (j + 1))) {
																	int traceTempVariable$var39$109_1 = distributionTempVariable$var15$88;
																	if((0 == (j + 1))) {
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$57_1) + traceTempVariable$var31$69_1) + traceTempVariable$var35$89_1) / traceTempVariable$var39$109_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample18Value87) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value87);
																		}
																	}
																	if(!true) {
																		for(int index$sample18$110 = 0; index$sample18$110 < weightings.length; index$sample18$110 += 1) {
																			int distributionTempVariable$var15$112 = index$sample18$110;
																			double cv$probabilitySample18Value111 = (cv$probabilitySample18Value87 * distribution$sample18[index$sample18$110]);
																			int traceTempVariable$var39$113_1 = distributionTempVariable$var15$112;
																			if((0 == (j + 1))) {
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$57_1) + traceTempVariable$var31$69_1) + traceTempVariable$var35$89_1) / traceTempVariable$var39$113_1);
																					double cv$weightedProbability = (Math.log(cv$probabilitySample18Value111) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																					if((cv$weightedProbability < cv$distributionAccumulator))
																						cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																					else {
																						if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																							cv$distributionAccumulator = cv$weightedProbability;
																						else
																							cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																					}
																					cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value111);
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					if(fixedFlag$sample12) {
						if(fixedFlag$sample18) {
							if((0 == j)) {
								if(fixedFlag$sample26) {
									for(int i = 0; i < size; i += 1) {
										if(((i + 1) == (j + 1))) {
											if((0 == (j + 1))) {
												{
													double var40 = ((((1.0 * v1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
													double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
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
										}
									}
								} else {
									for(int i = 0; i < size; i += 1) {
										if(true) {
											for(int index$sample26$131 = 0; index$sample26$131 < weightings.length; index$sample26$131 += 1) {
												int distributionTempVariable$var23$133 = index$sample26$131;
												double cv$probabilitySample26Value132 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$131]);
												int traceTempVariable$var35$134_1 = distributionTempVariable$var23$133;
												if(((i + 1) == (j + 1))) {
													if((0 == (j + 1))) {
														{
															double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$134_1) / v2[(j + 1)]);
															double cv$weightedProbability = (Math.log(cv$probabilitySample26Value132) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value132);
														}
													}
												}
											}
										}
									}
								}
							}
						} else {
							if(true) {
								for(int index$sample18$120 = 0; index$sample18$120 < weightings.length; index$sample18$120 += 1) {
									int distributionTempVariable$var15$122 = index$sample18$120;
									double cv$probabilitySample18Value121 = (1.0 * distribution$sample18[index$sample18$120]);
									int traceTempVariable$var31$123_1 = distributionTempVariable$var15$122;
									if((0 == j)) {
										if(fixedFlag$sample26) {
											for(int i = 0; i < size; i += 1) {
												if(((i + 1) == (j + 1))) {
													int traceTempVariable$var39$155_1 = distributionTempVariable$var15$122;
													if((0 == (j + 1))) {
														{
															double var40 = ((((1.0 * v1) + traceTempVariable$var31$123_1) + v2[(j + 1)]) / traceTempVariable$var39$155_1);
															double cv$weightedProbability = (Math.log(cv$probabilitySample18Value121) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value121);
														}
													}
													if(!true) {
														for(int index$sample18$156 = 0; index$sample18$156 < weightings.length; index$sample18$156 += 1) {
															int distributionTempVariable$var15$158 = index$sample18$156;
															double cv$probabilitySample18Value157 = (cv$probabilitySample18Value121 * distribution$sample18[index$sample18$156]);
															int traceTempVariable$var39$159_1 = distributionTempVariable$var15$158;
															if((0 == (j + 1))) {
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$123_1) + v2[(j + 1)]) / traceTempVariable$var39$159_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample18Value157) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value157);
																}
															}
														}
													}
												}
											}
										} else {
											for(int i = 0; i < size; i += 1) {
												if(true) {
													for(int index$sample26$137 = 0; index$sample26$137 < weightings.length; index$sample26$137 += 1) {
														int distributionTempVariable$var23$139 = index$sample26$137;
														double cv$probabilitySample26Value138 = (cv$probabilitySample18Value121 * distribution$sample26[((i - 0) / 1)][index$sample26$137]);
														int traceTempVariable$var35$140_1 = distributionTempVariable$var23$139;
														if(((i + 1) == (j + 1))) {
															int traceTempVariable$var39$160_1 = distributionTempVariable$var15$122;
															if((0 == (j + 1))) {
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$123_1) + traceTempVariable$var35$140_1) / traceTempVariable$var39$160_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample26Value138) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value138);
																}
															}
															if(!true) {
																for(int index$sample18$161 = 0; index$sample18$161 < weightings.length; index$sample18$161 += 1) {
																	int distributionTempVariable$var15$163 = index$sample18$161;
																	double cv$probabilitySample18Value162 = (cv$probabilitySample26Value138 * distribution$sample18[index$sample18$161]);
																	int traceTempVariable$var39$164_1 = distributionTempVariable$var15$163;
																	if((0 == (j + 1))) {
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$123_1) + traceTempVariable$var35$140_1) / traceTempVariable$var39$164_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample18Value162) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value162);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						if(true) {
							for(int index$sample12$115 = 0; index$sample12$115 < weightings.length; index$sample12$115 += 1) {
								int distributionTempVariable$v1$117 = index$sample12$115;
								double cv$probabilitySample12Value116 = (1.0 * distribution$sample12[index$sample12$115]);
								int traceTempVariable$v1$118_1 = distributionTempVariable$v1$117;
								if(fixedFlag$sample18) {
									if((0 == j)) {
										if(fixedFlag$sample26) {
											for(int i = 0; i < size; i += 1) {
												if(((i + 1) == (j + 1))) {
													if((0 == (j + 1))) {
														{
															double var40 = ((((1.0 * traceTempVariable$v1$118_1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
															double cv$weightedProbability = (Math.log(cv$probabilitySample12Value116) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample12Value116);
														}
													}
												}
											}
										} else {
											for(int i = 0; i < size; i += 1) {
												if(true) {
													for(int index$sample26$143 = 0; index$sample26$143 < weightings.length; index$sample26$143 += 1) {
														int distributionTempVariable$var23$145 = index$sample26$143;
														double cv$probabilitySample26Value144 = (cv$probabilitySample12Value116 * distribution$sample26[((i - 0) / 1)][index$sample26$143]);
														int traceTempVariable$var35$146_1 = distributionTempVariable$var23$145;
														if(((i + 1) == (j + 1))) {
															if((0 == (j + 1))) {
																{
																	double var40 = ((((1.0 * traceTempVariable$v1$118_1) + v2[j]) + traceTempVariable$var35$146_1) / v2[(j + 1)]);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample26Value144) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value144);
																}
															}
														}
													}
												}
											}
										}
									}
								} else {
									if(true) {
										for(int index$sample18$125 = 0; index$sample18$125 < weightings.length; index$sample18$125 += 1) {
											int distributionTempVariable$var15$127 = index$sample18$125;
											double cv$probabilitySample18Value126 = (cv$probabilitySample12Value116 * distribution$sample18[index$sample18$125]);
											int traceTempVariable$var31$128_1 = distributionTempVariable$var15$127;
											if((0 == j)) {
												if(fixedFlag$sample26) {
													for(int i = 0; i < size; i += 1) {
														if(((i + 1) == (j + 1))) {
															int traceTempVariable$var39$167_1 = distributionTempVariable$var15$127;
															if((0 == (j + 1))) {
																{
																	double var40 = ((((1.0 * traceTempVariable$v1$118_1) + traceTempVariable$var31$128_1) + v2[(j + 1)]) / traceTempVariable$var39$167_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample18Value126) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value126);
																}
															}
															if(!true) {
																for(int index$sample18$168 = 0; index$sample18$168 < weightings.length; index$sample18$168 += 1) {
																	int distributionTempVariable$var15$170 = index$sample18$168;
																	double cv$probabilitySample18Value169 = (cv$probabilitySample18Value126 * distribution$sample18[index$sample18$168]);
																	int traceTempVariable$var39$171_1 = distributionTempVariable$var15$170;
																	if((0 == (j + 1))) {
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$118_1) + traceTempVariable$var31$128_1) + v2[(j + 1)]) / traceTempVariable$var39$171_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample18Value169) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value169);
																		}
																	}
																}
															}
														}
													}
												} else {
													for(int i = 0; i < size; i += 1) {
														if(true) {
															for(int index$sample26$149 = 0; index$sample26$149 < weightings.length; index$sample26$149 += 1) {
																int distributionTempVariable$var23$151 = index$sample26$149;
																double cv$probabilitySample26Value150 = (cv$probabilitySample18Value126 * distribution$sample26[((i - 0) / 1)][index$sample26$149]);
																int traceTempVariable$var35$152_1 = distributionTempVariable$var23$151;
																if(((i + 1) == (j + 1))) {
																	int traceTempVariable$var39$172_1 = distributionTempVariable$var15$127;
																	if((0 == (j + 1))) {
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$118_1) + traceTempVariable$var31$128_1) + traceTempVariable$var35$152_1) / traceTempVariable$var39$172_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample26Value150) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value150);
																		}
																	}
																	if(!true) {
																		for(int index$sample18$173 = 0; index$sample18$173 < weightings.length; index$sample18$173 += 1) {
																			int distributionTempVariable$var15$175 = index$sample18$173;
																			double cv$probabilitySample18Value174 = (cv$probabilitySample26Value150 * distribution$sample18[index$sample18$173]);
																			int traceTempVariable$var39$176_1 = distributionTempVariable$var15$175;
																			if((0 == (j + 1))) {
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$118_1) + traceTempVariable$var31$128_1) + traceTempVariable$var35$152_1) / traceTempVariable$var39$176_1);
																					double cv$weightedProbability = (Math.log(cv$probabilitySample18Value174) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																					if((cv$weightedProbability < cv$distributionAccumulator))
																						cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																					else {
																						if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																							cv$distributionAccumulator = cv$weightedProbability;
																						else
																							cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																					}
																					cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value174);
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					if(fixedFlag$sample12) {
						if(fixedFlag$sample26) {
							for(int i = 0; i < size; i += 1) {
								if(((i + 1) == j)) {
									for(int index$i$194_1 = 0; index$i$194_1 < size; index$i$194_1 += 1) {
										if(((index$i$194_1 + 1) == (j + 1))) {
											if(fixedFlag$sample18) {
												if((0 == (j + 1))) {
													{
														double var40 = ((((1.0 * v1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
														double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
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
												if(true) {
													for(int index$sample18$209 = 0; index$sample18$209 < weightings.length; index$sample18$209 += 1) {
														int distributionTempVariable$var15$211 = index$sample18$209;
														double cv$probabilitySample18Value210 = (1.0 * distribution$sample18[index$sample18$209]);
														int traceTempVariable$var39$212_1 = distributionTempVariable$var15$211;
														if((0 == (j + 1))) {
															{
																double var40 = ((((1.0 * v1) + v2[j]) + v2[(j + 1)]) / traceTempVariable$var39$212_1);
																double cv$weightedProbability = (Math.log(cv$probabilitySample18Value210) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																if((cv$weightedProbability < cv$distributionAccumulator))
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																else {
																	if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																		cv$distributionAccumulator = cv$weightedProbability;
																	else
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																}
																cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value210);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						} else {
							for(int i = 0; i < size; i += 1) {
								if(true) {
									for(int index$sample26$184 = 0; index$sample26$184 < weightings.length; index$sample26$184 += 1) {
										int distributionTempVariable$var23$186 = index$sample26$184;
										double cv$probabilitySample26Value185 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$184]);
										int traceTempVariable$var31$187_1 = distributionTempVariable$var23$186;
										if(((i + 1) == j)) {
											int traceTempVariable$var35$195_1 = distributionTempVariable$var23$186;
											if(((i + 1) == (j + 1))) {
												if(fixedFlag$sample18) {
													if((0 == (j + 1))) {
														{
															double var40 = ((((1.0 * v1) + traceTempVariable$var31$187_1) + traceTempVariable$var35$195_1) / v2[(j + 1)]);
															double cv$weightedProbability = (Math.log(cv$probabilitySample26Value185) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value185);
														}
													}
												} else {
													if(true) {
														for(int index$sample18$214 = 0; index$sample18$214 < weightings.length; index$sample18$214 += 1) {
															int distributionTempVariable$var15$216 = index$sample18$214;
															double cv$probabilitySample18Value215 = (cv$probabilitySample26Value185 * distribution$sample18[index$sample18$214]);
															int traceTempVariable$var39$217_1 = distributionTempVariable$var15$216;
															if((0 == (j + 1))) {
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$187_1) + traceTempVariable$var35$195_1) / traceTempVariable$var39$217_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample18Value215) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value215);
																}
															}
														}
													}
												}
											}
											for(int index$i$196 = 0; index$i$196 < size; index$i$196 += 1) {
												if(!(index$i$196 == i)) {
													for(int index$sample26$197 = 0; index$sample26$197 < weightings.length; index$sample26$197 += 1) {
														int distributionTempVariable$var23$199 = index$sample26$197;
														double cv$probabilitySample26Value198 = (cv$probabilitySample26Value185 * distribution$sample26[((index$i$196 - 0) / 1)][index$sample26$197]);
														int traceTempVariable$var35$200_1 = distributionTempVariable$var23$199;
														if(((index$i$196 + 1) == (j + 1))) {
															if(fixedFlag$sample18) {
																if((0 == (j + 1))) {
																	{
																		double var40 = ((((1.0 * v1) + traceTempVariable$var31$187_1) + traceTempVariable$var35$200_1) / v2[(j + 1)]);
																		double cv$weightedProbability = (Math.log(cv$probabilitySample26Value198) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																		if((cv$weightedProbability < cv$distributionAccumulator))
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																		else {
																			if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																				cv$distributionAccumulator = cv$weightedProbability;
																			else
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																		}
																		cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value198);
																	}
																}
															} else {
																if(true) {
																	for(int index$sample18$219 = 0; index$sample18$219 < weightings.length; index$sample18$219 += 1) {
																		int distributionTempVariable$var15$221 = index$sample18$219;
																		double cv$probabilitySample18Value220 = (cv$probabilitySample26Value198 * distribution$sample18[index$sample18$219]);
																		int traceTempVariable$var39$222_1 = distributionTempVariable$var15$221;
																		if((0 == (j + 1))) {
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$187_1) + traceTempVariable$var35$200_1) / traceTempVariable$var39$222_1);
																				double cv$weightedProbability = (Math.log(cv$probabilitySample18Value220) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																				if((cv$weightedProbability < cv$distributionAccumulator))
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																				else {
																					if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																						cv$distributionAccumulator = cv$weightedProbability;
																					else
																						cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																				}
																				cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value220);
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						if(true) {
							for(int index$sample12$178 = 0; index$sample12$178 < weightings.length; index$sample12$178 += 1) {
								int distributionTempVariable$v1$180 = index$sample12$178;
								double cv$probabilitySample12Value179 = (1.0 * distribution$sample12[index$sample12$178]);
								int traceTempVariable$v1$181_1 = distributionTempVariable$v1$180;
								if(fixedFlag$sample26) {
									for(int i = 0; i < size; i += 1) {
										if(((i + 1) == j)) {
											for(int index$i$201_1 = 0; index$i$201_1 < size; index$i$201_1 += 1) {
												if(((index$i$201_1 + 1) == (j + 1))) {
													if(fixedFlag$sample18) {
														if((0 == (j + 1))) {
															{
																double var40 = ((((1.0 * traceTempVariable$v1$181_1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
																double cv$weightedProbability = (Math.log(cv$probabilitySample12Value179) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																if((cv$weightedProbability < cv$distributionAccumulator))
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																else {
																	if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																		cv$distributionAccumulator = cv$weightedProbability;
																	else
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																}
																cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample12Value179);
															}
														}
													} else {
														if(true) {
															for(int index$sample18$224 = 0; index$sample18$224 < weightings.length; index$sample18$224 += 1) {
																int distributionTempVariable$var15$226 = index$sample18$224;
																double cv$probabilitySample18Value225 = (cv$probabilitySample12Value179 * distribution$sample18[index$sample18$224]);
																int traceTempVariable$var39$227_1 = distributionTempVariable$var15$226;
																if((0 == (j + 1))) {
																	{
																		double var40 = ((((1.0 * traceTempVariable$v1$181_1) + v2[j]) + v2[(j + 1)]) / traceTempVariable$var39$227_1);
																		double cv$weightedProbability = (Math.log(cv$probabilitySample18Value225) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																		if((cv$weightedProbability < cv$distributionAccumulator))
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																		else {
																			if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																				cv$distributionAccumulator = cv$weightedProbability;
																			else
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																		}
																		cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value225);
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								} else {
									for(int i = 0; i < size; i += 1) {
										if(true) {
											for(int index$sample26$190 = 0; index$sample26$190 < weightings.length; index$sample26$190 += 1) {
												int distributionTempVariable$var23$192 = index$sample26$190;
												double cv$probabilitySample26Value191 = (cv$probabilitySample12Value179 * distribution$sample26[((i - 0) / 1)][index$sample26$190]);
												int traceTempVariable$var31$193_1 = distributionTempVariable$var23$192;
												if(((i + 1) == j)) {
													int traceTempVariable$var35$202_1 = distributionTempVariable$var23$192;
													if(((i + 1) == (j + 1))) {
														if(fixedFlag$sample18) {
															if((0 == (j + 1))) {
																{
																	double var40 = ((((1.0 * traceTempVariable$v1$181_1) + traceTempVariable$var31$193_1) + traceTempVariable$var35$202_1) / v2[(j + 1)]);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample26Value191) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value191);
																}
															}
														} else {
															if(true) {
																for(int index$sample18$229 = 0; index$sample18$229 < weightings.length; index$sample18$229 += 1) {
																	int distributionTempVariable$var15$231 = index$sample18$229;
																	double cv$probabilitySample18Value230 = (cv$probabilitySample26Value191 * distribution$sample18[index$sample18$229]);
																	int traceTempVariable$var39$232_1 = distributionTempVariable$var15$231;
																	if((0 == (j + 1))) {
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$181_1) + traceTempVariable$var31$193_1) + traceTempVariable$var35$202_1) / traceTempVariable$var39$232_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample18Value230) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value230);
																		}
																	}
																}
															}
														}
													}
													for(int index$i$203 = 0; index$i$203 < size; index$i$203 += 1) {
														if(!(index$i$203 == i)) {
															for(int index$sample26$204 = 0; index$sample26$204 < weightings.length; index$sample26$204 += 1) {
																int distributionTempVariable$var23$206 = index$sample26$204;
																double cv$probabilitySample26Value205 = (cv$probabilitySample26Value191 * distribution$sample26[((index$i$203 - 0) / 1)][index$sample26$204]);
																int traceTempVariable$var35$207_1 = distributionTempVariable$var23$206;
																if(((index$i$203 + 1) == (j + 1))) {
																	if(fixedFlag$sample18) {
																		if((0 == (j + 1))) {
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$181_1) + traceTempVariable$var31$193_1) + traceTempVariable$var35$207_1) / v2[(j + 1)]);
																				double cv$weightedProbability = (Math.log(cv$probabilitySample26Value205) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																				if((cv$weightedProbability < cv$distributionAccumulator))
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																				else {
																					if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																						cv$distributionAccumulator = cv$weightedProbability;
																					else
																						cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																				}
																				cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value205);
																			}
																		}
																	} else {
																		if(true) {
																			for(int index$sample18$234 = 0; index$sample18$234 < weightings.length; index$sample18$234 += 1) {
																				int distributionTempVariable$var15$236 = index$sample18$234;
																				double cv$probabilitySample18Value235 = (cv$probabilitySample26Value205 * distribution$sample18[index$sample18$234]);
																				int traceTempVariable$var39$237_1 = distributionTempVariable$var15$236;
																				if((0 == (j + 1))) {
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$181_1) + traceTempVariable$var31$193_1) + traceTempVariable$var35$207_1) / traceTempVariable$var39$237_1);
																						double cv$weightedProbability = (Math.log(cv$probabilitySample18Value235) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																						if((cv$weightedProbability < cv$distributionAccumulator))
																							cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																						else {
																							if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																								cv$distributionAccumulator = cv$weightedProbability;
																							else
																								cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																						}
																						cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value235);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					if(fixedFlag$sample12) {
						if(fixedFlag$sample18) {
							if((0 == j)) {
								if((0 == (j + 1))) {
									if(fixedFlag$sample26) {
										for(int i = 0; i < size; i += 1) {
											if(((i + 1) == (j + 1))) {
												{
													double var40 = ((((1.0 * v1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
													double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
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
										}
									} else {
										for(int i = 0; i < size; i += 1) {
											if(true) {
												for(int index$sample26$267 = 0; index$sample26$267 < weightings.length; index$sample26$267 += 1) {
													int distributionTempVariable$var23$269 = index$sample26$267;
													double cv$probabilitySample26Value268 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$267]);
													int traceTempVariable$var39$270_1 = distributionTempVariable$var23$269;
													if(((i + 1) == (j + 1))) {
														{
															double var40 = ((((1.0 * v1) + v2[j]) + v2[(j + 1)]) / traceTempVariable$var39$270_1);
															double cv$weightedProbability = (Math.log(cv$probabilitySample26Value268) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value268);
														}
													}
												}
											}
										}
									}
								}
							}
						} else {
							if(true) {
								for(int index$sample18$244 = 0; index$sample18$244 < weightings.length; index$sample18$244 += 1) {
									int distributionTempVariable$var15$246 = index$sample18$244;
									double cv$probabilitySample18Value245 = (1.0 * distribution$sample18[index$sample18$244]);
									int traceTempVariable$var31$247_1 = distributionTempVariable$var15$246;
									if((0 == j)) {
										int traceTempVariable$var35$254_1 = distributionTempVariable$var15$246;
										if((0 == (j + 1))) {
											if(fixedFlag$sample26) {
												for(int i = 0; i < size; i += 1) {
													if(((i + 1) == (j + 1))) {
														{
															double var40 = ((((1.0 * v1) + traceTempVariable$var31$247_1) + traceTempVariable$var35$254_1) / v2[(j + 1)]);
															double cv$weightedProbability = (Math.log(cv$probabilitySample18Value245) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value245);
														}
													}
												}
											} else {
												for(int i = 0; i < size; i += 1) {
													if(true) {
														for(int index$sample26$273 = 0; index$sample26$273 < weightings.length; index$sample26$273 += 1) {
															int distributionTempVariable$var23$275 = index$sample26$273;
															double cv$probabilitySample26Value274 = (cv$probabilitySample18Value245 * distribution$sample26[((i - 0) / 1)][index$sample26$273]);
															int traceTempVariable$var39$276_1 = distributionTempVariable$var23$275;
															if(((i + 1) == (j + 1))) {
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$247_1) + traceTempVariable$var35$254_1) / traceTempVariable$var39$276_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample26Value274) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value274);
																}
															}
														}
													}
												}
											}
										}
										if(!true) {
											for(int index$sample18$255 = 0; index$sample18$255 < weightings.length; index$sample18$255 += 1) {
												int distributionTempVariable$var15$257 = index$sample18$255;
												double cv$probabilitySample18Value256 = (cv$probabilitySample18Value245 * distribution$sample18[index$sample18$255]);
												int traceTempVariable$var35$258_1 = distributionTempVariable$var15$257;
												if((0 == (j + 1))) {
													if(fixedFlag$sample26) {
														for(int i = 0; i < size; i += 1) {
															if(((i + 1) == (j + 1))) {
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$247_1) + traceTempVariable$var35$258_1) / v2[(j + 1)]);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample18Value256) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value256);
																}
															}
														}
													} else {
														for(int i = 0; i < size; i += 1) {
															if(true) {
																for(int index$sample26$279 = 0; index$sample26$279 < weightings.length; index$sample26$279 += 1) {
																	int distributionTempVariable$var23$281 = index$sample26$279;
																	double cv$probabilitySample26Value280 = (cv$probabilitySample18Value256 * distribution$sample26[((i - 0) / 1)][index$sample26$279]);
																	int traceTempVariable$var39$282_1 = distributionTempVariable$var23$281;
																	if(((i + 1) == (j + 1))) {
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$247_1) + traceTempVariable$var35$258_1) / traceTempVariable$var39$282_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample26Value280) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value280);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						if(true) {
							for(int index$sample12$239 = 0; index$sample12$239 < weightings.length; index$sample12$239 += 1) {
								int distributionTempVariable$v1$241 = index$sample12$239;
								double cv$probabilitySample12Value240 = (1.0 * distribution$sample12[index$sample12$239]);
								int traceTempVariable$v1$242_1 = distributionTempVariable$v1$241;
								if(fixedFlag$sample18) {
									if((0 == j)) {
										if((0 == (j + 1))) {
											if(fixedFlag$sample26) {
												for(int i = 0; i < size; i += 1) {
													if(((i + 1) == (j + 1))) {
														{
															double var40 = ((((1.0 * traceTempVariable$v1$242_1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
															double cv$weightedProbability = (Math.log(cv$probabilitySample12Value240) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample12Value240);
														}
													}
												}
											} else {
												for(int i = 0; i < size; i += 1) {
													if(true) {
														for(int index$sample26$285 = 0; index$sample26$285 < weightings.length; index$sample26$285 += 1) {
															int distributionTempVariable$var23$287 = index$sample26$285;
															double cv$probabilitySample26Value286 = (cv$probabilitySample12Value240 * distribution$sample26[((i - 0) / 1)][index$sample26$285]);
															int traceTempVariable$var39$288_1 = distributionTempVariable$var23$287;
															if(((i + 1) == (j + 1))) {
																{
																	double var40 = ((((1.0 * traceTempVariable$v1$242_1) + v2[j]) + v2[(j + 1)]) / traceTempVariable$var39$288_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample26Value286) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value286);
																}
															}
														}
													}
												}
											}
										}
									}
								} else {
									if(true) {
										for(int index$sample18$249 = 0; index$sample18$249 < weightings.length; index$sample18$249 += 1) {
											int distributionTempVariable$var15$251 = index$sample18$249;
											double cv$probabilitySample18Value250 = (cv$probabilitySample12Value240 * distribution$sample18[index$sample18$249]);
											int traceTempVariable$var31$252_1 = distributionTempVariable$var15$251;
											if((0 == j)) {
												int traceTempVariable$var35$260_1 = distributionTempVariable$var15$251;
												if((0 == (j + 1))) {
													if(fixedFlag$sample26) {
														for(int i = 0; i < size; i += 1) {
															if(((i + 1) == (j + 1))) {
																{
																	double var40 = ((((1.0 * traceTempVariable$v1$242_1) + traceTempVariable$var31$252_1) + traceTempVariable$var35$260_1) / v2[(j + 1)]);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample18Value250) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value250);
																}
															}
														}
													} else {
														for(int i = 0; i < size; i += 1) {
															if(true) {
																for(int index$sample26$291 = 0; index$sample26$291 < weightings.length; index$sample26$291 += 1) {
																	int distributionTempVariable$var23$293 = index$sample26$291;
																	double cv$probabilitySample26Value292 = (cv$probabilitySample18Value250 * distribution$sample26[((i - 0) / 1)][index$sample26$291]);
																	int traceTempVariable$var39$294_1 = distributionTempVariable$var23$293;
																	if(((i + 1) == (j + 1))) {
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$242_1) + traceTempVariable$var31$252_1) + traceTempVariable$var35$260_1) / traceTempVariable$var39$294_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample26Value292) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value292);
																		}
																	}
																}
															}
														}
													}
												}
												if(!true) {
													for(int index$sample18$261 = 0; index$sample18$261 < weightings.length; index$sample18$261 += 1) {
														int distributionTempVariable$var15$263 = index$sample18$261;
														double cv$probabilitySample18Value262 = (cv$probabilitySample18Value250 * distribution$sample18[index$sample18$261]);
														int traceTempVariable$var35$264_1 = distributionTempVariable$var15$263;
														if((0 == (j + 1))) {
															if(fixedFlag$sample26) {
																for(int i = 0; i < size; i += 1) {
																	if(((i + 1) == (j + 1))) {
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$242_1) + traceTempVariable$var31$252_1) + traceTempVariable$var35$264_1) / v2[(j + 1)]);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample18Value262) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value262);
																		}
																	}
																}
															} else {
																for(int i = 0; i < size; i += 1) {
																	if(true) {
																		for(int index$sample26$297 = 0; index$sample26$297 < weightings.length; index$sample26$297 += 1) {
																			int distributionTempVariable$var23$299 = index$sample26$297;
																			double cv$probabilitySample26Value298 = (cv$probabilitySample18Value262 * distribution$sample26[((i - 0) / 1)][index$sample26$297]);
																			int traceTempVariable$var39$300_1 = distributionTempVariable$var23$299;
																			if(((i + 1) == (j + 1))) {
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$242_1) + traceTempVariable$var31$252_1) + traceTempVariable$var35$264_1) / traceTempVariable$var39$300_1);
																					double cv$weightedProbability = (Math.log(cv$probabilitySample26Value298) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																					if((cv$weightedProbability < cv$distributionAccumulator))
																						cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																					else {
																						if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																							cv$distributionAccumulator = cv$weightedProbability;
																						else
																							cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																					}
																					cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value298);
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					if(fixedFlag$sample12) {
						if(fixedFlag$sample26) {
							for(int i = 0; i < size; i += 1) {
								if(((i + 1) == j)) {
									if(fixedFlag$sample18) {
										if((0 == (j + 1))) {
											for(int index$i$338_1 = 0; index$i$338_1 < size; index$i$338_1 += 1) {
												if(((index$i$338_1 + 1) == (j + 1))) {
													{
														double var40 = ((((1.0 * v1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
														double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
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
											}
										}
									} else {
										if(true) {
											for(int index$sample18$319 = 0; index$sample18$319 < weightings.length; index$sample18$319 += 1) {
												int distributionTempVariable$var15$321 = index$sample18$319;
												double cv$probabilitySample18Value320 = (1.0 * distribution$sample18[index$sample18$319]);
												int traceTempVariable$var35$322_1 = distributionTempVariable$var15$321;
												if((0 == (j + 1))) {
													for(int index$i$339_1 = 0; index$i$339_1 < size; index$i$339_1 += 1) {
														if(((index$i$339_1 + 1) == (j + 1))) {
															{
																double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$322_1) / v2[(j + 1)]);
																double cv$weightedProbability = (Math.log(cv$probabilitySample18Value320) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																if((cv$weightedProbability < cv$distributionAccumulator))
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																else {
																	if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																		cv$distributionAccumulator = cv$weightedProbability;
																	else
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																}
																cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value320);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						} else {
							for(int i = 0; i < size; i += 1) {
								if(true) {
									for(int index$sample26$308 = 0; index$sample26$308 < weightings.length; index$sample26$308 += 1) {
										int distributionTempVariable$var23$310 = index$sample26$308;
										double cv$probabilitySample26Value309 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$308]);
										int traceTempVariable$var31$311_1 = distributionTempVariable$var23$310;
										if(((i + 1) == j)) {
											if(fixedFlag$sample18) {
												if((0 == (j + 1))) {
													int traceTempVariable$var39$340_1 = distributionTempVariable$var23$310;
													if(((i + 1) == (j + 1))) {
														{
															double var40 = ((((1.0 * v1) + traceTempVariable$var31$311_1) + v2[(j + 1)]) / traceTempVariable$var39$340_1);
															double cv$weightedProbability = (Math.log(cv$probabilitySample26Value309) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value309);
														}
													}
													for(int index$i$341 = 0; index$i$341 < size; index$i$341 += 1) {
														if(!(index$i$341 == i)) {
															for(int index$sample26$342 = 0; index$sample26$342 < weightings.length; index$sample26$342 += 1) {
																int distributionTempVariable$var23$344 = index$sample26$342;
																double cv$probabilitySample26Value343 = (cv$probabilitySample26Value309 * distribution$sample26[((index$i$341 - 0) / 1)][index$sample26$342]);
																int traceTempVariable$var39$345_1 = distributionTempVariable$var23$344;
																if(((index$i$341 + 1) == (j + 1))) {
																	{
																		double var40 = ((((1.0 * v1) + traceTempVariable$var31$311_1) + v2[(j + 1)]) / traceTempVariable$var39$345_1);
																		double cv$weightedProbability = (Math.log(cv$probabilitySample26Value343) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																		if((cv$weightedProbability < cv$distributionAccumulator))
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																		else {
																			if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																				cv$distributionAccumulator = cv$weightedProbability;
																			else
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																		}
																		cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value343);
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample18$324 = 0; index$sample18$324 < weightings.length; index$sample18$324 += 1) {
														int distributionTempVariable$var15$326 = index$sample18$324;
														double cv$probabilitySample18Value325 = (cv$probabilitySample26Value309 * distribution$sample18[index$sample18$324]);
														int traceTempVariable$var35$327_1 = distributionTempVariable$var15$326;
														if((0 == (j + 1))) {
															int traceTempVariable$var39$346_1 = distributionTempVariable$var23$310;
															if(((i + 1) == (j + 1))) {
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$311_1) + traceTempVariable$var35$327_1) / traceTempVariable$var39$346_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample18Value325) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value325);
																}
															}
															for(int index$i$347 = 0; index$i$347 < size; index$i$347 += 1) {
																if(!(index$i$347 == i)) {
																	for(int index$sample26$348 = 0; index$sample26$348 < weightings.length; index$sample26$348 += 1) {
																		int distributionTempVariable$var23$350 = index$sample26$348;
																		double cv$probabilitySample26Value349 = (cv$probabilitySample18Value325 * distribution$sample26[((index$i$347 - 0) / 1)][index$sample26$348]);
																		int traceTempVariable$var39$351_1 = distributionTempVariable$var23$350;
																		if(((index$i$347 + 1) == (j + 1))) {
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$311_1) + traceTempVariable$var35$327_1) / traceTempVariable$var39$351_1);
																				double cv$weightedProbability = (Math.log(cv$probabilitySample26Value349) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																				if((cv$weightedProbability < cv$distributionAccumulator))
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																				else {
																					if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																						cv$distributionAccumulator = cv$weightedProbability;
																					else
																						cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																				}
																				cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value349);
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						if(true) {
							for(int index$sample12$302 = 0; index$sample12$302 < weightings.length; index$sample12$302 += 1) {
								int distributionTempVariable$v1$304 = index$sample12$302;
								double cv$probabilitySample12Value303 = (1.0 * distribution$sample12[index$sample12$302]);
								int traceTempVariable$v1$305_1 = distributionTempVariable$v1$304;
								if(fixedFlag$sample26) {
									for(int i = 0; i < size; i += 1) {
										if(((i + 1) == j)) {
											if(fixedFlag$sample18) {
												if((0 == (j + 1))) {
													for(int index$i$352_1 = 0; index$i$352_1 < size; index$i$352_1 += 1) {
														if(((index$i$352_1 + 1) == (j + 1))) {
															{
																double var40 = ((((1.0 * traceTempVariable$v1$305_1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
																double cv$weightedProbability = (Math.log(cv$probabilitySample12Value303) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																if((cv$weightedProbability < cv$distributionAccumulator))
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																else {
																	if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																		cv$distributionAccumulator = cv$weightedProbability;
																	else
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																}
																cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample12Value303);
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample18$329 = 0; index$sample18$329 < weightings.length; index$sample18$329 += 1) {
														int distributionTempVariable$var15$331 = index$sample18$329;
														double cv$probabilitySample18Value330 = (cv$probabilitySample12Value303 * distribution$sample18[index$sample18$329]);
														int traceTempVariable$var35$332_1 = distributionTempVariable$var15$331;
														if((0 == (j + 1))) {
															for(int index$i$353_1 = 0; index$i$353_1 < size; index$i$353_1 += 1) {
																if(((index$i$353_1 + 1) == (j + 1))) {
																	{
																		double var40 = ((((1.0 * traceTempVariable$v1$305_1) + v2[j]) + traceTempVariable$var35$332_1) / v2[(j + 1)]);
																		double cv$weightedProbability = (Math.log(cv$probabilitySample18Value330) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																		if((cv$weightedProbability < cv$distributionAccumulator))
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																		else {
																			if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																				cv$distributionAccumulator = cv$weightedProbability;
																			else
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																		}
																		cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value330);
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								} else {
									for(int i = 0; i < size; i += 1) {
										if(true) {
											for(int index$sample26$314 = 0; index$sample26$314 < weightings.length; index$sample26$314 += 1) {
												int distributionTempVariable$var23$316 = index$sample26$314;
												double cv$probabilitySample26Value315 = (cv$probabilitySample12Value303 * distribution$sample26[((i - 0) / 1)][index$sample26$314]);
												int traceTempVariable$var31$317_1 = distributionTempVariable$var23$316;
												if(((i + 1) == j)) {
													if(fixedFlag$sample18) {
														if((0 == (j + 1))) {
															int traceTempVariable$var39$354_1 = distributionTempVariable$var23$316;
															if(((i + 1) == (j + 1))) {
																{
																	double var40 = ((((1.0 * traceTempVariable$v1$305_1) + traceTempVariable$var31$317_1) + v2[(j + 1)]) / traceTempVariable$var39$354_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample26Value315) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value315);
																}
															}
															for(int index$i$355 = 0; index$i$355 < size; index$i$355 += 1) {
																if(!(index$i$355 == i)) {
																	for(int index$sample26$356 = 0; index$sample26$356 < weightings.length; index$sample26$356 += 1) {
																		int distributionTempVariable$var23$358 = index$sample26$356;
																		double cv$probabilitySample26Value357 = (cv$probabilitySample26Value315 * distribution$sample26[((index$i$355 - 0) / 1)][index$sample26$356]);
																		int traceTempVariable$var39$359_1 = distributionTempVariable$var23$358;
																		if(((index$i$355 + 1) == (j + 1))) {
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$305_1) + traceTempVariable$var31$317_1) + v2[(j + 1)]) / traceTempVariable$var39$359_1);
																				double cv$weightedProbability = (Math.log(cv$probabilitySample26Value357) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																				if((cv$weightedProbability < cv$distributionAccumulator))
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																				else {
																					if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																						cv$distributionAccumulator = cv$weightedProbability;
																					else
																						cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																				}
																				cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value357);
																			}
																		}
																	}
																}
															}
														}
													} else {
														if(true) {
															for(int index$sample18$334 = 0; index$sample18$334 < weightings.length; index$sample18$334 += 1) {
																int distributionTempVariable$var15$336 = index$sample18$334;
																double cv$probabilitySample18Value335 = (cv$probabilitySample26Value315 * distribution$sample18[index$sample18$334]);
																int traceTempVariable$var35$337_1 = distributionTempVariable$var15$336;
																if((0 == (j + 1))) {
																	int traceTempVariable$var39$360_1 = distributionTempVariable$var23$316;
																	if(((i + 1) == (j + 1))) {
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$305_1) + traceTempVariable$var31$317_1) + traceTempVariable$var35$337_1) / traceTempVariable$var39$360_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample18Value335) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value335);
																		}
																	}
																	for(int index$i$361 = 0; index$i$361 < size; index$i$361 += 1) {
																		if(!(index$i$361 == i)) {
																			for(int index$sample26$362 = 0; index$sample26$362 < weightings.length; index$sample26$362 += 1) {
																				int distributionTempVariable$var23$364 = index$sample26$362;
																				double cv$probabilitySample26Value363 = (cv$probabilitySample18Value335 * distribution$sample26[((index$i$361 - 0) / 1)][index$sample26$362]);
																				int traceTempVariable$var39$365_1 = distributionTempVariable$var23$364;
																				if(((index$i$361 + 1) == (j + 1))) {
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$305_1) + traceTempVariable$var31$317_1) + traceTempVariable$var35$337_1) / traceTempVariable$var39$365_1);
																						double cv$weightedProbability = (Math.log(cv$probabilitySample26Value363) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																						if((cv$weightedProbability < cv$distributionAccumulator))
																							cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																						else {
																							if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																								cv$distributionAccumulator = cv$weightedProbability;
																							else
																								cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																						}
																						cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value363);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					if(fixedFlag$sample12) {
						if(fixedFlag$sample18) {
							if((0 == j)) {
								if(fixedFlag$sample26) {
									for(int i = 0; i < size; i += 1) {
										if(((i + 1) == (j + 1))) {
											for(int index$i$405_1 = 0; index$i$405_1 < size; index$i$405_1 += 1) {
												if(((index$i$405_1 + 1) == (j + 1))) {
													{
														double var40 = ((((1.0 * v1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
														double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
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
											}
										}
									}
								} else {
									for(int i = 0; i < size; i += 1) {
										if(true) {
											for(int index$sample26$383 = 0; index$sample26$383 < weightings.length; index$sample26$383 += 1) {
												int distributionTempVariable$var23$385 = index$sample26$383;
												double cv$probabilitySample26Value384 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$383]);
												int traceTempVariable$var35$386_1 = distributionTempVariable$var23$385;
												if(((i + 1) == (j + 1))) {
													int traceTempVariable$var39$406_1 = distributionTempVariable$var23$385;
													if(((i + 1) == (j + 1))) {
														{
															double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$386_1) / traceTempVariable$var39$406_1);
															double cv$weightedProbability = (Math.log(cv$probabilitySample26Value384) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
															if((cv$weightedProbability < cv$distributionAccumulator))
																cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
															else {
																if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																	cv$distributionAccumulator = cv$weightedProbability;
																else
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
															}
															cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value384);
														}
													}
													for(int index$i$407 = 0; index$i$407 < size; index$i$407 += 1) {
														if(!(index$i$407 == i)) {
															for(int index$sample26$408 = 0; index$sample26$408 < weightings.length; index$sample26$408 += 1) {
																int distributionTempVariable$var23$410 = index$sample26$408;
																double cv$probabilitySample26Value409 = (cv$probabilitySample26Value384 * distribution$sample26[((index$i$407 - 0) / 1)][index$sample26$408]);
																int traceTempVariable$var39$411_1 = distributionTempVariable$var23$410;
																if(((index$i$407 + 1) == (j + 1))) {
																	{
																		double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$386_1) / traceTempVariable$var39$411_1);
																		double cv$weightedProbability = (Math.log(cv$probabilitySample26Value409) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																		if((cv$weightedProbability < cv$distributionAccumulator))
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																		else {
																			if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																				cv$distributionAccumulator = cv$weightedProbability;
																			else
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																		}
																		cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value409);
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						} else {
							if(true) {
								for(int index$sample18$372 = 0; index$sample18$372 < weightings.length; index$sample18$372 += 1) {
									int distributionTempVariable$var15$374 = index$sample18$372;
									double cv$probabilitySample18Value373 = (1.0 * distribution$sample18[index$sample18$372]);
									int traceTempVariable$var31$375_1 = distributionTempVariable$var15$374;
									if((0 == j)) {
										if(fixedFlag$sample26) {
											for(int i = 0; i < size; i += 1) {
												if(((i + 1) == (j + 1))) {
													for(int index$i$412_1 = 0; index$i$412_1 < size; index$i$412_1 += 1) {
														if(((index$i$412_1 + 1) == (j + 1))) {
															{
																double var40 = ((((1.0 * v1) + traceTempVariable$var31$375_1) + v2[(j + 1)]) / v2[(j + 1)]);
																double cv$weightedProbability = (Math.log(cv$probabilitySample18Value373) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																if((cv$weightedProbability < cv$distributionAccumulator))
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																else {
																	if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																		cv$distributionAccumulator = cv$weightedProbability;
																	else
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																}
																cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value373);
															}
														}
													}
												}
											}
										} else {
											for(int i = 0; i < size; i += 1) {
												if(true) {
													for(int index$sample26$389 = 0; index$sample26$389 < weightings.length; index$sample26$389 += 1) {
														int distributionTempVariable$var23$391 = index$sample26$389;
														double cv$probabilitySample26Value390 = (cv$probabilitySample18Value373 * distribution$sample26[((i - 0) / 1)][index$sample26$389]);
														int traceTempVariable$var35$392_1 = distributionTempVariable$var23$391;
														if(((i + 1) == (j + 1))) {
															int traceTempVariable$var39$413_1 = distributionTempVariable$var23$391;
															if(((i + 1) == (j + 1))) {
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$375_1) + traceTempVariable$var35$392_1) / traceTempVariable$var39$413_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample26Value390) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value390);
																}
															}
															for(int index$i$414 = 0; index$i$414 < size; index$i$414 += 1) {
																if(!(index$i$414 == i)) {
																	for(int index$sample26$415 = 0; index$sample26$415 < weightings.length; index$sample26$415 += 1) {
																		int distributionTempVariable$var23$417 = index$sample26$415;
																		double cv$probabilitySample26Value416 = (cv$probabilitySample26Value390 * distribution$sample26[((index$i$414 - 0) / 1)][index$sample26$415]);
																		int traceTempVariable$var39$418_1 = distributionTempVariable$var23$417;
																		if(((index$i$414 + 1) == (j + 1))) {
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$375_1) + traceTempVariable$var35$392_1) / traceTempVariable$var39$418_1);
																				double cv$weightedProbability = (Math.log(cv$probabilitySample26Value416) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																				if((cv$weightedProbability < cv$distributionAccumulator))
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																				else {
																					if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																						cv$distributionAccumulator = cv$weightedProbability;
																					else
																						cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																				}
																				cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value416);
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						if(true) {
							for(int index$sample12$367 = 0; index$sample12$367 < weightings.length; index$sample12$367 += 1) {
								int distributionTempVariable$v1$369 = index$sample12$367;
								double cv$probabilitySample12Value368 = (1.0 * distribution$sample12[index$sample12$367]);
								int traceTempVariable$v1$370_1 = distributionTempVariable$v1$369;
								if(fixedFlag$sample18) {
									if((0 == j)) {
										if(fixedFlag$sample26) {
											for(int i = 0; i < size; i += 1) {
												if(((i + 1) == (j + 1))) {
													for(int index$i$419_1 = 0; index$i$419_1 < size; index$i$419_1 += 1) {
														if(((index$i$419_1 + 1) == (j + 1))) {
															{
																double var40 = ((((1.0 * traceTempVariable$v1$370_1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
																double cv$weightedProbability = (Math.log(cv$probabilitySample12Value368) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																if((cv$weightedProbability < cv$distributionAccumulator))
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																else {
																	if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																		cv$distributionAccumulator = cv$weightedProbability;
																	else
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																}
																cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample12Value368);
															}
														}
													}
												}
											}
										} else {
											for(int i = 0; i < size; i += 1) {
												if(true) {
													for(int index$sample26$395 = 0; index$sample26$395 < weightings.length; index$sample26$395 += 1) {
														int distributionTempVariable$var23$397 = index$sample26$395;
														double cv$probabilitySample26Value396 = (cv$probabilitySample12Value368 * distribution$sample26[((i - 0) / 1)][index$sample26$395]);
														int traceTempVariable$var35$398_1 = distributionTempVariable$var23$397;
														if(((i + 1) == (j + 1))) {
															int traceTempVariable$var39$420_1 = distributionTempVariable$var23$397;
															if(((i + 1) == (j + 1))) {
																{
																	double var40 = ((((1.0 * traceTempVariable$v1$370_1) + v2[j]) + traceTempVariable$var35$398_1) / traceTempVariable$var39$420_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample26Value396) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value396);
																}
															}
															for(int index$i$421 = 0; index$i$421 < size; index$i$421 += 1) {
																if(!(index$i$421 == i)) {
																	for(int index$sample26$422 = 0; index$sample26$422 < weightings.length; index$sample26$422 += 1) {
																		int distributionTempVariable$var23$424 = index$sample26$422;
																		double cv$probabilitySample26Value423 = (cv$probabilitySample26Value396 * distribution$sample26[((index$i$421 - 0) / 1)][index$sample26$422]);
																		int traceTempVariable$var39$425_1 = distributionTempVariable$var23$424;
																		if(((index$i$421 + 1) == (j + 1))) {
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$370_1) + v2[j]) + traceTempVariable$var35$398_1) / traceTempVariable$var39$425_1);
																				double cv$weightedProbability = (Math.log(cv$probabilitySample26Value423) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																				if((cv$weightedProbability < cv$distributionAccumulator))
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																				else {
																					if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																						cv$distributionAccumulator = cv$weightedProbability;
																					else
																						cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																				}
																				cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value423);
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								} else {
									if(true) {
										for(int index$sample18$377 = 0; index$sample18$377 < weightings.length; index$sample18$377 += 1) {
											int distributionTempVariable$var15$379 = index$sample18$377;
											double cv$probabilitySample18Value378 = (cv$probabilitySample12Value368 * distribution$sample18[index$sample18$377]);
											int traceTempVariable$var31$380_1 = distributionTempVariable$var15$379;
											if((0 == j)) {
												if(fixedFlag$sample26) {
													for(int i = 0; i < size; i += 1) {
														if(((i + 1) == (j + 1))) {
															for(int index$i$426_1 = 0; index$i$426_1 < size; index$i$426_1 += 1) {
																if(((index$i$426_1 + 1) == (j + 1))) {
																	{
																		double var40 = ((((1.0 * traceTempVariable$v1$370_1) + traceTempVariable$var31$380_1) + v2[(j + 1)]) / v2[(j + 1)]);
																		double cv$weightedProbability = (Math.log(cv$probabilitySample18Value378) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																		if((cv$weightedProbability < cv$distributionAccumulator))
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																		else {
																			if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																				cv$distributionAccumulator = cv$weightedProbability;
																			else
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																		}
																		cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample18Value378);
																	}
																}
															}
														}
													}
												} else {
													for(int i = 0; i < size; i += 1) {
														if(true) {
															for(int index$sample26$401 = 0; index$sample26$401 < weightings.length; index$sample26$401 += 1) {
																int distributionTempVariable$var23$403 = index$sample26$401;
																double cv$probabilitySample26Value402 = (cv$probabilitySample18Value378 * distribution$sample26[((i - 0) / 1)][index$sample26$401]);
																int traceTempVariable$var35$404_1 = distributionTempVariable$var23$403;
																if(((i + 1) == (j + 1))) {
																	int traceTempVariable$var39$427_1 = distributionTempVariable$var23$403;
																	if(((i + 1) == (j + 1))) {
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$370_1) + traceTempVariable$var31$380_1) + traceTempVariable$var35$404_1) / traceTempVariable$var39$427_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample26Value402) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value402);
																		}
																	}
																	for(int index$i$428 = 0; index$i$428 < size; index$i$428 += 1) {
																		if(!(index$i$428 == i)) {
																			for(int index$sample26$429 = 0; index$sample26$429 < weightings.length; index$sample26$429 += 1) {
																				int distributionTempVariable$var23$431 = index$sample26$429;
																				double cv$probabilitySample26Value430 = (cv$probabilitySample26Value402 * distribution$sample26[((index$i$428 - 0) / 1)][index$sample26$429]);
																				int traceTempVariable$var39$432_1 = distributionTempVariable$var23$431;
																				if(((index$i$428 + 1) == (j + 1))) {
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$370_1) + traceTempVariable$var31$380_1) + traceTempVariable$var35$404_1) / traceTempVariable$var39$432_1);
																						double cv$weightedProbability = (Math.log(cv$probabilitySample26Value430) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																						if((cv$weightedProbability < cv$distributionAccumulator))
																							cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																						else {
																							if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																								cv$distributionAccumulator = cv$weightedProbability;
																							else
																								cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																						}
																						cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value430);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					if(fixedFlag$sample12) {
						if(fixedFlag$sample26) {
							for(int i = 0; i < size; i += 1) {
								if(((i + 1) == j)) {
									for(int index$i$450_1 = 0; index$i$450_1 < size; index$i$450_1 += 1) {
										if(((index$i$450_1 + 1) == (j + 1))) {
											for(int index$i$464_1 = 0; index$i$464_1 < size; index$i$464_1 += 1) {
												if(((index$i$464_1 + 1) == (j + 1))) {
													{
														double var40 = ((((1.0 * v1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
														double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
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
											}
										}
									}
								}
							}
						} else {
							for(int i = 0; i < size; i += 1) {
								if(true) {
									for(int index$sample26$440 = 0; index$sample26$440 < weightings.length; index$sample26$440 += 1) {
										int distributionTempVariable$var23$442 = index$sample26$440;
										double cv$probabilitySample26Value441 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$440]);
										int traceTempVariable$var31$443_1 = distributionTempVariable$var23$442;
										if(((i + 1) == j)) {
											int traceTempVariable$var35$451_1 = distributionTempVariable$var23$442;
											if(((i + 1) == (j + 1))) {
												int traceTempVariable$var39$465_1 = distributionTempVariable$var23$442;
												if(((i + 1) == (j + 1))) {
													{
														double var40 = ((((1.0 * v1) + traceTempVariable$var31$443_1) + traceTempVariable$var35$451_1) / traceTempVariable$var39$465_1);
														double cv$weightedProbability = (Math.log(cv$probabilitySample26Value441) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
														if((cv$weightedProbability < cv$distributionAccumulator))
															cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
														else {
															if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																cv$distributionAccumulator = cv$weightedProbability;
															else
																cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
														}
														cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value441);
													}
												}
												for(int index$i$466 = 0; index$i$466 < size; index$i$466 += 1) {
													if(!(index$i$466 == i)) {
														for(int index$sample26$467 = 0; index$sample26$467 < weightings.length; index$sample26$467 += 1) {
															int distributionTempVariable$var23$469 = index$sample26$467;
															double cv$probabilitySample26Value468 = (cv$probabilitySample26Value441 * distribution$sample26[((index$i$466 - 0) / 1)][index$sample26$467]);
															int traceTempVariable$var39$470_1 = distributionTempVariable$var23$469;
															if(((index$i$466 + 1) == (j + 1))) {
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$443_1) + traceTempVariable$var35$451_1) / traceTempVariable$var39$470_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample26Value468) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value468);
																}
															}
														}
													}
												}
											}
											for(int index$i$452 = 0; index$i$452 < size; index$i$452 += 1) {
												if(!(index$i$452 == i)) {
													for(int index$sample26$453 = 0; index$sample26$453 < weightings.length; index$sample26$453 += 1) {
														int distributionTempVariable$var23$455 = index$sample26$453;
														double cv$probabilitySample26Value454 = (cv$probabilitySample26Value441 * distribution$sample26[((index$i$452 - 0) / 1)][index$sample26$453]);
														int traceTempVariable$var35$456_1 = distributionTempVariable$var23$455;
														if(((index$i$452 + 1) == (j + 1))) {
															int traceTempVariable$var39$471_1 = distributionTempVariable$var23$442;
															if(((i + 1) == (j + 1))) {
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$443_1) + traceTempVariable$var35$456_1) / traceTempVariable$var39$471_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample26Value454) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value454);
																}
															}
															int traceTempVariable$var39$472_1 = distributionTempVariable$var23$455;
															if(((index$i$452 + 1) == (j + 1))) {
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$443_1) + traceTempVariable$var35$456_1) / traceTempVariable$var39$472_1);
																	double cv$weightedProbability = (Math.log(cv$probabilitySample26Value454) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																	if((cv$weightedProbability < cv$distributionAccumulator))
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																	else {
																		if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																			cv$distributionAccumulator = cv$weightedProbability;
																		else
																			cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																	}
																	cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value454);
																}
															}
															for(int index$i$473 = 0; index$i$473 < size; index$i$473 += 1) {
																if((!(index$i$473 == i) && !(index$i$473 == index$i$452))) {
																	for(int index$sample26$474 = 0; index$sample26$474 < weightings.length; index$sample26$474 += 1) {
																		int distributionTempVariable$var23$476 = index$sample26$474;
																		double cv$probabilitySample26Value475 = (cv$probabilitySample26Value454 * distribution$sample26[((index$i$473 - 0) / 1)][index$sample26$474]);
																		int traceTempVariable$var39$477_1 = distributionTempVariable$var23$476;
																		if(((index$i$473 + 1) == (j + 1))) {
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$443_1) + traceTempVariable$var35$456_1) / traceTempVariable$var39$477_1);
																				double cv$weightedProbability = (Math.log(cv$probabilitySample26Value475) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																				if((cv$weightedProbability < cv$distributionAccumulator))
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																				else {
																					if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																						cv$distributionAccumulator = cv$weightedProbability;
																					else
																						cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																				}
																				cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value475);
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						if(true) {
							for(int index$sample12$434 = 0; index$sample12$434 < weightings.length; index$sample12$434 += 1) {
								int distributionTempVariable$v1$436 = index$sample12$434;
								double cv$probabilitySample12Value435 = (1.0 * distribution$sample12[index$sample12$434]);
								int traceTempVariable$v1$437_1 = distributionTempVariable$v1$436;
								if(fixedFlag$sample26) {
									for(int i = 0; i < size; i += 1) {
										if(((i + 1) == j)) {
											for(int index$i$457_1 = 0; index$i$457_1 < size; index$i$457_1 += 1) {
												if(((index$i$457_1 + 1) == (j + 1))) {
													for(int index$i$478_1 = 0; index$i$478_1 < size; index$i$478_1 += 1) {
														if(((index$i$478_1 + 1) == (j + 1))) {
															{
																double var40 = ((((1.0 * traceTempVariable$v1$437_1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
																double cv$weightedProbability = (Math.log(cv$probabilitySample12Value435) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																if((cv$weightedProbability < cv$distributionAccumulator))
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																else {
																	if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																		cv$distributionAccumulator = cv$weightedProbability;
																	else
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																}
																cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample12Value435);
															}
														}
													}
												}
											}
										}
									}
								} else {
									for(int i = 0; i < size; i += 1) {
										if(true) {
											for(int index$sample26$446 = 0; index$sample26$446 < weightings.length; index$sample26$446 += 1) {
												int distributionTempVariable$var23$448 = index$sample26$446;
												double cv$probabilitySample26Value447 = (cv$probabilitySample12Value435 * distribution$sample26[((i - 0) / 1)][index$sample26$446]);
												int traceTempVariable$var31$449_1 = distributionTempVariable$var23$448;
												if(((i + 1) == j)) {
													int traceTempVariable$var35$458_1 = distributionTempVariable$var23$448;
													if(((i + 1) == (j + 1))) {
														int traceTempVariable$var39$479_1 = distributionTempVariable$var23$448;
														if(((i + 1) == (j + 1))) {
															{
																double var40 = ((((1.0 * traceTempVariable$v1$437_1) + traceTempVariable$var31$449_1) + traceTempVariable$var35$458_1) / traceTempVariable$var39$479_1);
																double cv$weightedProbability = (Math.log(cv$probabilitySample26Value447) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																if((cv$weightedProbability < cv$distributionAccumulator))
																	cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																else {
																	if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																		cv$distributionAccumulator = cv$weightedProbability;
																	else
																		cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																}
																cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value447);
															}
														}
														for(int index$i$480 = 0; index$i$480 < size; index$i$480 += 1) {
															if(!(index$i$480 == i)) {
																for(int index$sample26$481 = 0; index$sample26$481 < weightings.length; index$sample26$481 += 1) {
																	int distributionTempVariable$var23$483 = index$sample26$481;
																	double cv$probabilitySample26Value482 = (cv$probabilitySample26Value447 * distribution$sample26[((index$i$480 - 0) / 1)][index$sample26$481]);
																	int traceTempVariable$var39$484_1 = distributionTempVariable$var23$483;
																	if(((index$i$480 + 1) == (j + 1))) {
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$437_1) + traceTempVariable$var31$449_1) + traceTempVariable$var35$458_1) / traceTempVariable$var39$484_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample26Value482) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value482);
																		}
																	}
																}
															}
														}
													}
													for(int index$i$459 = 0; index$i$459 < size; index$i$459 += 1) {
														if(!(index$i$459 == i)) {
															for(int index$sample26$460 = 0; index$sample26$460 < weightings.length; index$sample26$460 += 1) {
																int distributionTempVariable$var23$462 = index$sample26$460;
																double cv$probabilitySample26Value461 = (cv$probabilitySample26Value447 * distribution$sample26[((index$i$459 - 0) / 1)][index$sample26$460]);
																int traceTempVariable$var35$463_1 = distributionTempVariable$var23$462;
																if(((index$i$459 + 1) == (j + 1))) {
																	int traceTempVariable$var39$485_1 = distributionTempVariable$var23$448;
																	if(((i + 1) == (j + 1))) {
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$437_1) + traceTempVariable$var31$449_1) + traceTempVariable$var35$463_1) / traceTempVariable$var39$485_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample26Value461) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value461);
																		}
																	}
																	int traceTempVariable$var39$486_1 = distributionTempVariable$var23$462;
																	if(((index$i$459 + 1) == (j + 1))) {
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$437_1) + traceTempVariable$var31$449_1) + traceTempVariable$var35$463_1) / traceTempVariable$var39$486_1);
																			double cv$weightedProbability = (Math.log(cv$probabilitySample26Value461) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																			if((cv$weightedProbability < cv$distributionAccumulator))
																				cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																			else {
																				if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																					cv$distributionAccumulator = cv$weightedProbability;
																				else
																					cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																			}
																			cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value461);
																		}
																	}
																	for(int index$i$487 = 0; index$i$487 < size; index$i$487 += 1) {
																		if((!(index$i$487 == i) && !(index$i$487 == index$i$459))) {
																			for(int index$sample26$488 = 0; index$sample26$488 < weightings.length; index$sample26$488 += 1) {
																				int distributionTempVariable$var23$490 = index$sample26$488;
																				double cv$probabilitySample26Value489 = (cv$probabilitySample26Value461 * distribution$sample26[((index$i$487 - 0) / 1)][index$sample26$488]);
																				int traceTempVariable$var39$491_1 = distributionTempVariable$var23$490;
																				if(((index$i$487 + 1) == (j + 1))) {
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$437_1) + traceTempVariable$var31$449_1) + traceTempVariable$var35$463_1) / traceTempVariable$var39$491_1);
																						double cv$weightedProbability = (Math.log(cv$probabilitySample26Value489) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
																						if((cv$weightedProbability < cv$distributionAccumulator))
																							cv$distributionAccumulator = (Math.log((Math.exp((cv$weightedProbability - cv$distributionAccumulator)) + 1)) + cv$distributionAccumulator);
																						else {
																							if((cv$distributionAccumulator == Double.NEGATIVE_INFINITY))
																								cv$distributionAccumulator = cv$weightedProbability;
																							else
																								cv$distributionAccumulator = (Math.log((Math.exp((cv$distributionAccumulator - cv$weightedProbability)) + 1)) + cv$weightedProbability);
																						}
																						cv$probabilityReached = (cv$probabilityReached + cv$probabilitySample26Value489);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				if((cv$probabilityReached == 0.0))
					cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				else
					cv$distributionAccumulator = (cv$distributionAccumulator - Math.log(cv$probabilityReached));
				double cv$sampleProbability = cv$distributionAccumulator;
				cv$sampleAccumulator = (cv$sampleAccumulator + cv$sampleProbability);
				cv$accumulator = (cv$accumulator + cv$sampleAccumulator);
				logProbability$var41[((j - 0) / 1)] = cv$sampleAccumulator;
				logProbability$sample45[((j - 0) / 1)] = cv$sampleProbability;
			}
			logProbability$v = (logProbability$v + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			fixedProbFlag$sample45 = (((fixedFlag$sample45 && fixedFlag$sample12) && fixedFlag$sample18) && fixedFlag$sample26);
		} else {
			double cv$accumulator = 0.0;
			for(int j = 0; j < size; j += 1) {
				double cv$rvAccumulator = 0.0;
				double cv$sampleValue = logProbability$sample45[((j - 0) / 1)];
				cv$rvAccumulator = (cv$rvAccumulator + cv$sampleValue);
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var41[((j - 0) / 1)] = cv$rvAccumulator;
			}
			logProbability$v = (logProbability$v + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityValue$sample12() {
		if(!fixedProbFlag$sample12) {
			double cv$accumulator = 0.0;
			double cv$sampleAccumulator = 0.0;
			double cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
			double cv$probabilityReached = 0.0;
			{
				int cv$sampleValue = v1;
				{
					{
						double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityCategorical(cv$sampleValue, weightings));
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
			}
			if((cv$probabilityReached == 0.0))
				cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
			else
				cv$distributionAccumulator = (cv$distributionAccumulator - Math.log(cv$probabilityReached));
			double cv$sampleProbability = cv$distributionAccumulator;
			cv$sampleAccumulator = (cv$sampleAccumulator + cv$sampleProbability);
			cv$accumulator = (cv$accumulator + cv$sampleAccumulator);
			logProbability$var8 = cv$sampleAccumulator;
			logProbability$v1 = cv$sampleProbability;
			logProbability$$model = (logProbability$$model + cv$accumulator);
			if(fixedFlag$sample12)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			fixedProbFlag$sample12 = fixedFlag$sample12;
		} else {
			double cv$accumulator = 0.0;
			double cv$rvAccumulator = 0.0;
			double cv$sampleValue = logProbability$v1;
			cv$rvAccumulator = (cv$rvAccumulator + cv$sampleValue);
			cv$accumulator = (cv$accumulator + cv$rvAccumulator);
			logProbability$var8 = cv$rvAccumulator;
			logProbability$$model = (logProbability$$model + cv$accumulator);
			if(fixedFlag$sample12)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityValue$sample18() {
		if(!fixedProbFlag$sample18) {
			double cv$accumulator = 0.0;
			double cv$sampleAccumulator = 0.0;
			double cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
			double cv$probabilityReached = 0.0;
			{
				int cv$sampleValue = v2[0];
				{
					{
						double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityCategorical(cv$sampleValue, weightings));
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
			}
			if((cv$probabilityReached == 0.0))
				cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
			else
				cv$distributionAccumulator = (cv$distributionAccumulator - Math.log(cv$probabilityReached));
			double cv$sampleProbability = cv$distributionAccumulator;
			cv$sampleAccumulator = (cv$sampleAccumulator + cv$sampleProbability);
			cv$accumulator = (cv$accumulator + cv$sampleAccumulator);
			logProbability$var14 = cv$sampleAccumulator;
			logProbability$var15 = cv$sampleProbability;
			logProbability$v2 = (logProbability$v2 + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			if(fixedFlag$sample18)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			fixedProbFlag$sample18 = fixedFlag$sample18;
		} else {
			double cv$accumulator = 0.0;
			double cv$rvAccumulator = 0.0;
			double cv$sampleValue = logProbability$var15;
			cv$rvAccumulator = (cv$rvAccumulator + cv$sampleValue);
			cv$accumulator = (cv$accumulator + cv$rvAccumulator);
			logProbability$var14 = cv$rvAccumulator;
			logProbability$v2 = (logProbability$v2 + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			if(fixedFlag$sample18)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityValue$sample26() {
		if(!fixedProbFlag$sample26) {
			double cv$accumulator = 0.0;
			for(int i = 0; i < size; i += 1) {
				double cv$sampleAccumulator = 0.0;
				double cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				double cv$probabilityReached = 0.0;
				int index$i$1 = i;
				{
					int cv$sampleValue = v2[(i + 1)];
					{
						{
							double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityCategorical(cv$sampleValue, weightings));
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
				}
				if((cv$probabilityReached == 0.0))
					cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				else
					cv$distributionAccumulator = (cv$distributionAccumulator - Math.log(cv$probabilityReached));
				double cv$sampleProbability = cv$distributionAccumulator;
				cv$sampleAccumulator = (cv$sampleAccumulator + cv$sampleProbability);
				cv$accumulator = (cv$accumulator + cv$sampleAccumulator);
				logProbability$var22[((i - 0) / 1)] = cv$sampleAccumulator;
				logProbability$sample26[((i - 0) / 1)] = cv$sampleProbability;
			}
			logProbability$v2 = (logProbability$v2 + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			if(fixedFlag$sample26)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			fixedProbFlag$sample26 = fixedFlag$sample26;
		} else {
			double cv$accumulator = 0.0;
			for(int i = 0; i < size; i += 1) {
				double cv$rvAccumulator = 0.0;
				double cv$sampleValue = logProbability$sample26[((i - 0) / 1)];
				cv$rvAccumulator = (cv$rvAccumulator + cv$sampleValue);
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var22[((i - 0) / 1)] = cv$rvAccumulator;
			}
			logProbability$v2 = (logProbability$v2 + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			if(fixedFlag$sample26)
				logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void logProbabilityValue$sample45() {
		if(!fixedProbFlag$sample45) {
			double cv$accumulator = 0.0;
			for(int j = 0; j < size; j += 1) {
				double cv$sampleAccumulator = 0.0;
				double cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				double cv$probabilityReached = 0.0;
				{
					boolean cv$sampleValue = v[j];
					{
						{
							double var40 = ((((1.0 * v1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
							double cv$weightedProbability = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(cv$sampleValue, var40));
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
				}
				if((cv$probabilityReached == 0.0))
					cv$distributionAccumulator = Double.NEGATIVE_INFINITY;
				else
					cv$distributionAccumulator = (cv$distributionAccumulator - Math.log(cv$probabilityReached));
				double cv$sampleProbability = cv$distributionAccumulator;
				cv$sampleAccumulator = (cv$sampleAccumulator + cv$sampleProbability);
				cv$accumulator = (cv$accumulator + cv$sampleAccumulator);
				logProbability$var41[((j - 0) / 1)] = cv$sampleAccumulator;
				logProbability$sample45[((j - 0) / 1)] = cv$sampleProbability;
			}
			logProbability$v = (logProbability$v + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
			fixedProbFlag$sample45 = (((fixedFlag$sample45 && fixedFlag$sample12) && fixedFlag$sample18) && fixedFlag$sample26);
		} else {
			double cv$accumulator = 0.0;
			for(int j = 0; j < size; j += 1) {
				double cv$rvAccumulator = 0.0;
				double cv$sampleValue = logProbability$sample45[((j - 0) / 1)];
				cv$rvAccumulator = (cv$rvAccumulator + cv$sampleValue);
				cv$accumulator = (cv$accumulator + cv$rvAccumulator);
				logProbability$var41[((j - 0) / 1)] = cv$rvAccumulator;
			}
			logProbability$v = (logProbability$v + cv$accumulator);
			logProbability$$model = (logProbability$$model + cv$accumulator);
			logProbability$$evidence = (logProbability$$evidence + cv$accumulator);
		}
	}

	private final void sample12() {
		double[] cv$stateProbabilityLocal = cv$var9$stateProbabilityGlobal;
		for(int cv$valuePos = 0; cv$valuePos < weightings.length; cv$valuePos += 1) {
			double cv$stateProbabilityValue = Double.NEGATIVE_INFINITY;
			double cv$reachedDistributionSourceRV = 0.0;
			double cv$accumulatedDistributionProbabilities = 0.0;
			int cv$currentValue;
			cv$currentValue = cv$valuePos;
			{
				cv$reachedDistributionSourceRV = (cv$reachedDistributionSourceRV + 1.0);
				double[] cv$temp$0$weightings;
				{
					cv$temp$0$weightings = weightings;
				}
				double cv$accumulatedProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityCategorical(cv$currentValue, cv$temp$0$weightings));
				{
					{
						for(int j = 0; j < size; j += 1) {
							int traceTempVariable$v1$1_2 = cv$currentValue;
							{
								double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
								double cv$consumerDistributionProbabilityAccumulator = 1.0;
								{
									if(fixedFlag$sample18) {
										if((0 == j)) {
											if((0 == (j + 1))) {
												if((0 == (j + 1))) {
													{
														{
															double cv$temp$1$var40;
															{
																double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
																cv$temp$1$var40 = var40;
															}
															if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40)) < cv$accumulatedConsumerProbabilities))
																cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
															else {
																if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																	cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40));
																else
																	cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40)));
															}
															cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
														}
													}
												}
											}
										}
									} else {
										if(true) {
											for(int index$sample18$4 = 0; index$sample18$4 < weightings.length; index$sample18$4 += 1) {
												int distributionTempVariable$var15$6 = index$sample18$4;
												double cv$probabilitySample18Value5 = (1.0 * distribution$sample18[index$sample18$4]);
												int traceTempVariable$var31$7_1 = distributionTempVariable$var15$6;
												if((0 == j)) {
													int traceTempVariable$var35$9_1 = distributionTempVariable$var15$6;
													if((0 == (j + 1))) {
														int traceTempVariable$var39$15_1 = distributionTempVariable$var15$6;
														if((0 == (j + 1))) {
															{
																{
																	double cv$temp$2$var40;
																	{
																		double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$7_1) + traceTempVariable$var35$9_1) / traceTempVariable$var39$15_1);
																		cv$temp$2$var40 = var40;
																	}
																	if(((Math.log(cv$probabilitySample18Value5) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40)) < cv$accumulatedConsumerProbabilities))
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value5) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																	else {
																		if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																			cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value5) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40));
																		else
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value5) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value5) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40)));
																	}
																	cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value5);
																}
															}
														}
														if(!true) {
															for(int index$sample18$16 = 0; index$sample18$16 < weightings.length; index$sample18$16 += 1) {
																int distributionTempVariable$var15$18 = index$sample18$16;
																double cv$probabilitySample18Value17 = (cv$probabilitySample18Value5 * distribution$sample18[index$sample18$16]);
																int traceTempVariable$var39$19_1 = distributionTempVariable$var15$18;
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$3$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$7_1) + traceTempVariable$var35$9_1) / traceTempVariable$var39$19_1);
																				cv$temp$3$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value17);
																		}
																	}
																}
															}
														}
													}
													if(!true) {
														for(int index$sample18$10 = 0; index$sample18$10 < weightings.length; index$sample18$10 += 1) {
															int distributionTempVariable$var15$12 = index$sample18$10;
															double cv$probabilitySample18Value11 = (cv$probabilitySample18Value5 * distribution$sample18[index$sample18$10]);
															int traceTempVariable$var35$13_1 = distributionTempVariable$var15$12;
															if((0 == (j + 1))) {
																int traceTempVariable$var39$20_1 = distributionTempVariable$var15$6;
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$4$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$7_1) + traceTempVariable$var35$13_1) / traceTempVariable$var39$20_1);
																				cv$temp$4$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value11) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value11) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value11) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value11) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value11) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value11);
																		}
																	}
																}
																int traceTempVariable$var39$21_1 = distributionTempVariable$var15$12;
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$5$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$7_1) + traceTempVariable$var35$13_1) / traceTempVariable$var39$21_1);
																				cv$temp$5$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value11) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value11) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value11) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value11) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value11) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value11);
																		}
																	}
																}
																if(!true) {
																	for(int index$sample18$22 = 0; index$sample18$22 < weightings.length; index$sample18$22 += 1) {
																		int distributionTempVariable$var15$24 = index$sample18$22;
																		double cv$probabilitySample18Value23 = (cv$probabilitySample18Value11 * distribution$sample18[index$sample18$22]);
																		int traceTempVariable$var39$25_1 = distributionTempVariable$var15$24;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$6$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$7_1) + traceTempVariable$var35$13_1) / traceTempVariable$var39$25_1);
																						cv$temp$6$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value23) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value23) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value23) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value23) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value23) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value23);
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
									if(fixedFlag$sample26) {
										for(int i = 0; i < size; i += 1) {
											if(((i + 1) == j)) {
												if(fixedFlag$sample18) {
													if((0 == (j + 1))) {
														if((0 == (j + 1))) {
															{
																{
																	double cv$temp$7$var40;
																	{
																		double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
																		cv$temp$7$var40 = var40;
																	}
																	if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40)) < cv$accumulatedConsumerProbabilities))
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																	else {
																		if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																			cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40));
																		else
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40)));
																	}
																	cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																}
															}
														}
													}
												} else {
													if(true) {
														for(int index$sample18$33 = 0; index$sample18$33 < weightings.length; index$sample18$33 += 1) {
															int distributionTempVariable$var15$35 = index$sample18$33;
															double cv$probabilitySample18Value34 = (1.0 * distribution$sample18[index$sample18$33]);
															int traceTempVariable$var35$36_1 = distributionTempVariable$var15$35;
															if((0 == (j + 1))) {
																int traceTempVariable$var39$43_1 = distributionTempVariable$var15$35;
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$8$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + traceTempVariable$var35$36_1) / traceTempVariable$var39$43_1);
																				cv$temp$8$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value34) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value34) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value34) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value34) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value34) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value34);
																		}
																	}
																}
																if(!true) {
																	for(int index$sample18$44 = 0; index$sample18$44 < weightings.length; index$sample18$44 += 1) {
																		int distributionTempVariable$var15$46 = index$sample18$44;
																		double cv$probabilitySample18Value45 = (cv$probabilitySample18Value34 * distribution$sample18[index$sample18$44]);
																		int traceTempVariable$var39$47_1 = distributionTempVariable$var15$46;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$9$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + traceTempVariable$var35$36_1) / traceTempVariable$var39$47_1);
																						cv$temp$9$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value45) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value45) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value45) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value45) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value45) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value45);
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									} else {
										for(int i = 0; i < size; i += 1) {
											if(true) {
												for(int index$sample26$28 = 0; index$sample26$28 < weightings.length; index$sample26$28 += 1) {
													int distributionTempVariable$var23$30 = index$sample26$28;
													double cv$probabilitySample26Value29 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$28]);
													int traceTempVariable$var31$31_1 = distributionTempVariable$var23$30;
													if(((i + 1) == j)) {
														if(fixedFlag$sample18) {
															if((0 == (j + 1))) {
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$10$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$31_1) + v2[(j + 1)]) / v2[(j + 1)]);
																				cv$temp$10$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value29) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value29) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value29) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value29) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value29) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value29);
																		}
																	}
																}
															}
														} else {
															if(true) {
																for(int index$sample18$38 = 0; index$sample18$38 < weightings.length; index$sample18$38 += 1) {
																	int distributionTempVariable$var15$40 = index$sample18$38;
																	double cv$probabilitySample18Value39 = (cv$probabilitySample26Value29 * distribution$sample18[index$sample18$38]);
																	int traceTempVariable$var35$41_1 = distributionTempVariable$var15$40;
																	if((0 == (j + 1))) {
																		int traceTempVariable$var39$49_1 = distributionTempVariable$var15$40;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$11$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$31_1) + traceTempVariable$var35$41_1) / traceTempVariable$var39$49_1);
																						cv$temp$11$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value39) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value39) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value39) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value39) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value39) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value39);
																				}
																			}
																		}
																		if(!true) {
																			for(int index$sample18$50 = 0; index$sample18$50 < weightings.length; index$sample18$50 += 1) {
																				int distributionTempVariable$var15$52 = index$sample18$50;
																				double cv$probabilitySample18Value51 = (cv$probabilitySample18Value39 * distribution$sample18[index$sample18$50]);
																				int traceTempVariable$var39$53_1 = distributionTempVariable$var15$52;
																				if((0 == (j + 1))) {
																					{
																						{
																							double cv$temp$12$var40;
																							{
																								double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$31_1) + traceTempVariable$var35$41_1) / traceTempVariable$var39$53_1);
																								cv$temp$12$var40 = var40;
																							}
																							if(((Math.log(cv$probabilitySample18Value51) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40)) < cv$accumulatedConsumerProbabilities))
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value51) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																							else {
																								if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																									cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value51) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40));
																								else
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value51) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value51) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40)));
																							}
																							cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value51);
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
									if(fixedFlag$sample18) {
										if((0 == j)) {
											if(fixedFlag$sample26) {
												for(int i = 0; i < size; i += 1) {
													if(((i + 1) == (j + 1))) {
														if((0 == (j + 1))) {
															{
																{
																	double cv$temp$13$var40;
																	{
																		double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
																		cv$temp$13$var40 = var40;
																	}
																	if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40)) < cv$accumulatedConsumerProbabilities))
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																	else {
																		if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																			cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40));
																		else
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40)));
																	}
																	cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																}
															}
														}
													}
												}
											} else {
												for(int i = 0; i < size; i += 1) {
													if(true) {
														for(int index$sample26$61 = 0; index$sample26$61 < weightings.length; index$sample26$61 += 1) {
															int distributionTempVariable$var23$63 = index$sample26$61;
															double cv$probabilitySample26Value62 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$61]);
															int traceTempVariable$var35$64_1 = distributionTempVariable$var23$63;
															if(((i + 1) == (j + 1))) {
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$14$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + traceTempVariable$var35$64_1) / v2[(j + 1)]);
																				cv$temp$14$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value62) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value62) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value62) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value62) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value62) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value62);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									} else {
										if(true) {
											for(int index$sample18$55 = 0; index$sample18$55 < weightings.length; index$sample18$55 += 1) {
												int distributionTempVariable$var15$57 = index$sample18$55;
												double cv$probabilitySample18Value56 = (1.0 * distribution$sample18[index$sample18$55]);
												int traceTempVariable$var31$58_1 = distributionTempVariable$var15$57;
												if((0 == j)) {
													if(fixedFlag$sample26) {
														for(int i = 0; i < size; i += 1) {
															if(((i + 1) == (j + 1))) {
																int traceTempVariable$var39$73_1 = distributionTempVariable$var15$57;
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$15$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$58_1) + v2[(j + 1)]) / traceTempVariable$var39$73_1);
																				cv$temp$15$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value56) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value56) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value56) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value56) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value56) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value56);
																		}
																	}
																}
																if(!true) {
																	for(int index$sample18$74 = 0; index$sample18$74 < weightings.length; index$sample18$74 += 1) {
																		int distributionTempVariable$var15$76 = index$sample18$74;
																		double cv$probabilitySample18Value75 = (cv$probabilitySample18Value56 * distribution$sample18[index$sample18$74]);
																		int traceTempVariable$var39$77_1 = distributionTempVariable$var15$76;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$16$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$58_1) + v2[(j + 1)]) / traceTempVariable$var39$77_1);
																						cv$temp$16$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value75) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value75) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value75) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value75) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value75) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value75);
																				}
																			}
																		}
																	}
																}
															}
														}
													} else {
														for(int i = 0; i < size; i += 1) {
															if(true) {
																for(int index$sample26$67 = 0; index$sample26$67 < weightings.length; index$sample26$67 += 1) {
																	int distributionTempVariable$var23$69 = index$sample26$67;
																	double cv$probabilitySample26Value68 = (cv$probabilitySample18Value56 * distribution$sample26[((i - 0) / 1)][index$sample26$67]);
																	int traceTempVariable$var35$70_1 = distributionTempVariable$var23$69;
																	if(((i + 1) == (j + 1))) {
																		int traceTempVariable$var39$78_1 = distributionTempVariable$var15$57;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$17$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$58_1) + traceTempVariable$var35$70_1) / traceTempVariable$var39$78_1);
																						cv$temp$17$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value68) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value68) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value68) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value68) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value68) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value68);
																				}
																			}
																		}
																		if(!true) {
																			for(int index$sample18$79 = 0; index$sample18$79 < weightings.length; index$sample18$79 += 1) {
																				int distributionTempVariable$var15$81 = index$sample18$79;
																				double cv$probabilitySample18Value80 = (cv$probabilitySample26Value68 * distribution$sample18[index$sample18$79]);
																				int traceTempVariable$var39$82_1 = distributionTempVariable$var15$81;
																				if((0 == (j + 1))) {
																					{
																						{
																							double cv$temp$18$var40;
																							{
																								double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$58_1) + traceTempVariable$var35$70_1) / traceTempVariable$var39$82_1);
																								cv$temp$18$var40 = var40;
																							}
																							if(((Math.log(cv$probabilitySample18Value80) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40)) < cv$accumulatedConsumerProbabilities))
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value80) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																							else {
																								if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																									cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value80) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40));
																								else
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value80) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value80) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40)));
																							}
																							cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value80);
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
									if(fixedFlag$sample26) {
										for(int i = 0; i < size; i += 1) {
											if(((i + 1) == j)) {
												for(int index$i$89_1 = 0; index$i$89_1 < size; index$i$89_1 += 1) {
													if(((index$i$89_1 + 1) == (j + 1))) {
														if(fixedFlag$sample18) {
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$19$var40;
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
																			cv$temp$19$var40 = var40;
																		}
																		if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																	}
																}
															}
														} else {
															if(true) {
																for(int index$sample18$97 = 0; index$sample18$97 < weightings.length; index$sample18$97 += 1) {
																	int distributionTempVariable$var15$99 = index$sample18$97;
																	double cv$probabilitySample18Value98 = (1.0 * distribution$sample18[index$sample18$97]);
																	int traceTempVariable$var39$100_1 = distributionTempVariable$var15$99;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$20$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + v2[(j + 1)]) / traceTempVariable$var39$100_1);
																					cv$temp$20$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value98) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value98) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value98) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value98) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value98) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value98);
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									} else {
										for(int i = 0; i < size; i += 1) {
											if(true) {
												for(int index$sample26$85 = 0; index$sample26$85 < weightings.length; index$sample26$85 += 1) {
													int distributionTempVariable$var23$87 = index$sample26$85;
													double cv$probabilitySample26Value86 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$85]);
													int traceTempVariable$var31$88_1 = distributionTempVariable$var23$87;
													if(((i + 1) == j)) {
														int traceTempVariable$var35$90_1 = distributionTempVariable$var23$87;
														if(((i + 1) == (j + 1))) {
															if(fixedFlag$sample18) {
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$21$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$88_1) + traceTempVariable$var35$90_1) / v2[(j + 1)]);
																				cv$temp$21$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value86) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value86) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value86) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value86) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value86) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value86);
																		}
																	}
																}
															} else {
																if(true) {
																	for(int index$sample18$102 = 0; index$sample18$102 < weightings.length; index$sample18$102 += 1) {
																		int distributionTempVariable$var15$104 = index$sample18$102;
																		double cv$probabilitySample18Value103 = (cv$probabilitySample26Value86 * distribution$sample18[index$sample18$102]);
																		int traceTempVariable$var39$105_1 = distributionTempVariable$var15$104;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$22$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$88_1) + traceTempVariable$var35$90_1) / traceTempVariable$var39$105_1);
																						cv$temp$22$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value103) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value103) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value103) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value103) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value103) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value103);
																				}
																			}
																		}
																	}
																}
															}
														}
														for(int index$i$91 = 0; index$i$91 < size; index$i$91 += 1) {
															if(!(index$i$91 == i)) {
																for(int index$sample26$92 = 0; index$sample26$92 < weightings.length; index$sample26$92 += 1) {
																	int distributionTempVariable$var23$94 = index$sample26$92;
																	double cv$probabilitySample26Value93 = (cv$probabilitySample26Value86 * distribution$sample26[((index$i$91 - 0) / 1)][index$sample26$92]);
																	int traceTempVariable$var35$95_1 = distributionTempVariable$var23$94;
																	if(((index$i$91 + 1) == (j + 1))) {
																		if(fixedFlag$sample18) {
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$23$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$88_1) + traceTempVariable$var35$95_1) / v2[(j + 1)]);
																							cv$temp$23$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value93) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value93) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value93) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value93) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value93) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value93);
																					}
																				}
																			}
																		} else {
																			if(true) {
																				for(int index$sample18$107 = 0; index$sample18$107 < weightings.length; index$sample18$107 += 1) {
																					int distributionTempVariable$var15$109 = index$sample18$107;
																					double cv$probabilitySample18Value108 = (cv$probabilitySample26Value93 * distribution$sample18[index$sample18$107]);
																					int traceTempVariable$var39$110_1 = distributionTempVariable$var15$109;
																					if((0 == (j + 1))) {
																						{
																							{
																								double cv$temp$24$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$88_1) + traceTempVariable$var35$95_1) / traceTempVariable$var39$110_1);
																									cv$temp$24$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample18Value108) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value108) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value108) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value108) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value108) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value108);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
									if(fixedFlag$sample18) {
										if((0 == j)) {
											if((0 == (j + 1))) {
												if(fixedFlag$sample26) {
													for(int i = 0; i < size; i += 1) {
														if(((i + 1) == (j + 1))) {
															{
																{
																	double cv$temp$25$var40;
																	{
																		double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
																		cv$temp$25$var40 = var40;
																	}
																	if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40)) < cv$accumulatedConsumerProbabilities))
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																	else {
																		if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																			cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40));
																		else
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40)));
																	}
																	cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																}
															}
														}
													}
												} else {
													for(int i = 0; i < size; i += 1) {
														if(true) {
															for(int index$sample26$124 = 0; index$sample26$124 < weightings.length; index$sample26$124 += 1) {
																int distributionTempVariable$var23$126 = index$sample26$124;
																double cv$probabilitySample26Value125 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$124]);
																int traceTempVariable$var39$127_1 = distributionTempVariable$var23$126;
																if(((i + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$26$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + v2[(j + 1)]) / traceTempVariable$var39$127_1);
																				cv$temp$26$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value125) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value125) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value125) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value125) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value125) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value125);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									} else {
										if(true) {
											for(int index$sample18$112 = 0; index$sample18$112 < weightings.length; index$sample18$112 += 1) {
												int distributionTempVariable$var15$114 = index$sample18$112;
												double cv$probabilitySample18Value113 = (1.0 * distribution$sample18[index$sample18$112]);
												int traceTempVariable$var31$115_1 = distributionTempVariable$var15$114;
												if((0 == j)) {
													int traceTempVariable$var35$117_1 = distributionTempVariable$var15$114;
													if((0 == (j + 1))) {
														if(fixedFlag$sample26) {
															for(int i = 0; i < size; i += 1) {
																if(((i + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$27$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$115_1) + traceTempVariable$var35$117_1) / v2[(j + 1)]);
																				cv$temp$27$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value113) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value113) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value113) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value113) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value113) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value113);
																		}
																	}
																}
															}
														} else {
															for(int i = 0; i < size; i += 1) {
																if(true) {
																	for(int index$sample26$130 = 0; index$sample26$130 < weightings.length; index$sample26$130 += 1) {
																		int distributionTempVariable$var23$132 = index$sample26$130;
																		double cv$probabilitySample26Value131 = (cv$probabilitySample18Value113 * distribution$sample26[((i - 0) / 1)][index$sample26$130]);
																		int traceTempVariable$var39$133_1 = distributionTempVariable$var23$132;
																		if(((i + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$28$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$115_1) + traceTempVariable$var35$117_1) / traceTempVariable$var39$133_1);
																						cv$temp$28$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value131) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value131) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value131) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value131) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value131) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value131);
																				}
																			}
																		}
																	}
																}
															}
														}
													}
													if(!true) {
														for(int index$sample18$118 = 0; index$sample18$118 < weightings.length; index$sample18$118 += 1) {
															int distributionTempVariable$var15$120 = index$sample18$118;
															double cv$probabilitySample18Value119 = (cv$probabilitySample18Value113 * distribution$sample18[index$sample18$118]);
															int traceTempVariable$var35$121_1 = distributionTempVariable$var15$120;
															if((0 == (j + 1))) {
																if(fixedFlag$sample26) {
																	for(int i = 0; i < size; i += 1) {
																		if(((i + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$29$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$115_1) + traceTempVariable$var35$121_1) / v2[(j + 1)]);
																						cv$temp$29$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value119) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value119) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value119) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value119) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value119) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value119);
																				}
																			}
																		}
																	}
																} else {
																	for(int i = 0; i < size; i += 1) {
																		if(true) {
																			for(int index$sample26$136 = 0; index$sample26$136 < weightings.length; index$sample26$136 += 1) {
																				int distributionTempVariable$var23$138 = index$sample26$136;
																				double cv$probabilitySample26Value137 = (cv$probabilitySample18Value119 * distribution$sample26[((i - 0) / 1)][index$sample26$136]);
																				int traceTempVariable$var39$139_1 = distributionTempVariable$var23$138;
																				if(((i + 1) == (j + 1))) {
																					{
																						{
																							double cv$temp$30$var40;
																							{
																								double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$115_1) + traceTempVariable$var35$121_1) / traceTempVariable$var39$139_1);
																								cv$temp$30$var40 = var40;
																							}
																							if(((Math.log(cv$probabilitySample26Value137) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40)) < cv$accumulatedConsumerProbabilities))
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value137) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																							else {
																								if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																									cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value137) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40));
																								else
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value137) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value137) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40)));
																							}
																							cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value137);
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
									if(fixedFlag$sample26) {
										for(int i = 0; i < size; i += 1) {
											if(((i + 1) == j)) {
												if(fixedFlag$sample18) {
													if((0 == (j + 1))) {
														for(int index$i$156_1 = 0; index$i$156_1 < size; index$i$156_1 += 1) {
															if(((index$i$156_1 + 1) == (j + 1))) {
																{
																	{
																		double cv$temp$31$var40;
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
																			cv$temp$31$var40 = var40;
																		}
																		if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																	}
																}
															}
														}
													}
												} else {
													if(true) {
														for(int index$sample18$147 = 0; index$sample18$147 < weightings.length; index$sample18$147 += 1) {
															int distributionTempVariable$var15$149 = index$sample18$147;
															double cv$probabilitySample18Value148 = (1.0 * distribution$sample18[index$sample18$147]);
															int traceTempVariable$var35$150_1 = distributionTempVariable$var15$149;
															if((0 == (j + 1))) {
																for(int index$i$157_1 = 0; index$i$157_1 < size; index$i$157_1 += 1) {
																	if(((index$i$157_1 + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$32$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + traceTempVariable$var35$150_1) / v2[(j + 1)]);
																					cv$temp$32$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value148) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value148) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value148) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value148) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value148) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value148);
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									} else {
										for(int i = 0; i < size; i += 1) {
											if(true) {
												for(int index$sample26$142 = 0; index$sample26$142 < weightings.length; index$sample26$142 += 1) {
													int distributionTempVariable$var23$144 = index$sample26$142;
													double cv$probabilitySample26Value143 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$142]);
													int traceTempVariable$var31$145_1 = distributionTempVariable$var23$144;
													if(((i + 1) == j)) {
														if(fixedFlag$sample18) {
															if((0 == (j + 1))) {
																int traceTempVariable$var39$158_1 = distributionTempVariable$var23$144;
																if(((i + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$33$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$145_1) + v2[(j + 1)]) / traceTempVariable$var39$158_1);
																				cv$temp$33$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value143) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value143) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value143) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value143) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value143) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value143);
																		}
																	}
																}
																for(int index$i$159 = 0; index$i$159 < size; index$i$159 += 1) {
																	if(!(index$i$159 == i)) {
																		for(int index$sample26$160 = 0; index$sample26$160 < weightings.length; index$sample26$160 += 1) {
																			int distributionTempVariable$var23$162 = index$sample26$160;
																			double cv$probabilitySample26Value161 = (cv$probabilitySample26Value143 * distribution$sample26[((index$i$159 - 0) / 1)][index$sample26$160]);
																			int traceTempVariable$var39$163_1 = distributionTempVariable$var23$162;
																			if(((index$i$159 + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$34$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$145_1) + v2[(j + 1)]) / traceTempVariable$var39$163_1);
																							cv$temp$34$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value161);
																					}
																				}
																			}
																		}
																	}
																}
															}
														} else {
															if(true) {
																for(int index$sample18$152 = 0; index$sample18$152 < weightings.length; index$sample18$152 += 1) {
																	int distributionTempVariable$var15$154 = index$sample18$152;
																	double cv$probabilitySample18Value153 = (cv$probabilitySample26Value143 * distribution$sample18[index$sample18$152]);
																	int traceTempVariable$var35$155_1 = distributionTempVariable$var15$154;
																	if((0 == (j + 1))) {
																		int traceTempVariable$var39$164_1 = distributionTempVariable$var23$144;
																		if(((i + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$35$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$145_1) + traceTempVariable$var35$155_1) / traceTempVariable$var39$164_1);
																						cv$temp$35$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value153) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value153) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value153) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value153) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value153) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value153);
																				}
																			}
																		}
																		for(int index$i$165 = 0; index$i$165 < size; index$i$165 += 1) {
																			if(!(index$i$165 == i)) {
																				for(int index$sample26$166 = 0; index$sample26$166 < weightings.length; index$sample26$166 += 1) {
																					int distributionTempVariable$var23$168 = index$sample26$166;
																					double cv$probabilitySample26Value167 = (cv$probabilitySample18Value153 * distribution$sample26[((index$i$165 - 0) / 1)][index$sample26$166]);
																					int traceTempVariable$var39$169_1 = distributionTempVariable$var23$168;
																					if(((index$i$165 + 1) == (j + 1))) {
																						{
																							{
																								double cv$temp$36$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$145_1) + traceTempVariable$var35$155_1) / traceTempVariable$var39$169_1);
																									cv$temp$36$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample26Value167) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value167) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value167) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value167) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value167) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value167);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
									if(fixedFlag$sample18) {
										if((0 == j)) {
											if(fixedFlag$sample26) {
												for(int i = 0; i < size; i += 1) {
													if(((i + 1) == (j + 1))) {
														for(int index$i$187_1 = 0; index$i$187_1 < size; index$i$187_1 += 1) {
															if(((index$i$187_1 + 1) == (j + 1))) {
																{
																	{
																		double cv$temp$37$var40;
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
																			cv$temp$37$var40 = var40;
																		}
																		if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																	}
																}
															}
														}
													}
												}
											} else {
												for(int i = 0; i < size; i += 1) {
													if(true) {
														for(int index$sample26$177 = 0; index$sample26$177 < weightings.length; index$sample26$177 += 1) {
															int distributionTempVariable$var23$179 = index$sample26$177;
															double cv$probabilitySample26Value178 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$177]);
															int traceTempVariable$var35$180_1 = distributionTempVariable$var23$179;
															if(((i + 1) == (j + 1))) {
																int traceTempVariable$var39$188_1 = distributionTempVariable$var23$179;
																if(((i + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$38$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + traceTempVariable$var35$180_1) / traceTempVariable$var39$188_1);
																				cv$temp$38$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value178) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value178) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value178) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value178) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value178) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value178);
																		}
																	}
																}
																for(int index$i$189 = 0; index$i$189 < size; index$i$189 += 1) {
																	if(!(index$i$189 == i)) {
																		for(int index$sample26$190 = 0; index$sample26$190 < weightings.length; index$sample26$190 += 1) {
																			int distributionTempVariable$var23$192 = index$sample26$190;
																			double cv$probabilitySample26Value191 = (cv$probabilitySample26Value178 * distribution$sample26[((index$i$189 - 0) / 1)][index$sample26$190]);
																			int traceTempVariable$var39$193_1 = distributionTempVariable$var23$192;
																			if(((index$i$189 + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$39$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + traceTempVariable$var35$180_1) / traceTempVariable$var39$193_1);
																							cv$temp$39$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value191) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value191) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value191) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value191) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value191) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value191);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									} else {
										if(true) {
											for(int index$sample18$171 = 0; index$sample18$171 < weightings.length; index$sample18$171 += 1) {
												int distributionTempVariable$var15$173 = index$sample18$171;
												double cv$probabilitySample18Value172 = (1.0 * distribution$sample18[index$sample18$171]);
												int traceTempVariable$var31$174_1 = distributionTempVariable$var15$173;
												if((0 == j)) {
													if(fixedFlag$sample26) {
														for(int i = 0; i < size; i += 1) {
															if(((i + 1) == (j + 1))) {
																for(int index$i$194_1 = 0; index$i$194_1 < size; index$i$194_1 += 1) {
																	if(((index$i$194_1 + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$40$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$174_1) + v2[(j + 1)]) / v2[(j + 1)]);
																					cv$temp$40$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value172) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value172) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value172) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value172) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value172) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value172);
																			}
																		}
																	}
																}
															}
														}
													} else {
														for(int i = 0; i < size; i += 1) {
															if(true) {
																for(int index$sample26$183 = 0; index$sample26$183 < weightings.length; index$sample26$183 += 1) {
																	int distributionTempVariable$var23$185 = index$sample26$183;
																	double cv$probabilitySample26Value184 = (cv$probabilitySample18Value172 * distribution$sample26[((i - 0) / 1)][index$sample26$183]);
																	int traceTempVariable$var35$186_1 = distributionTempVariable$var23$185;
																	if(((i + 1) == (j + 1))) {
																		int traceTempVariable$var39$195_1 = distributionTempVariable$var23$185;
																		if(((i + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$41$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$174_1) + traceTempVariable$var35$186_1) / traceTempVariable$var39$195_1);
																						cv$temp$41$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value184) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value184) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value184) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value184) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value184) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value184);
																				}
																			}
																		}
																		for(int index$i$196 = 0; index$i$196 < size; index$i$196 += 1) {
																			if(!(index$i$196 == i)) {
																				for(int index$sample26$197 = 0; index$sample26$197 < weightings.length; index$sample26$197 += 1) {
																					int distributionTempVariable$var23$199 = index$sample26$197;
																					double cv$probabilitySample26Value198 = (cv$probabilitySample26Value184 * distribution$sample26[((index$i$196 - 0) / 1)][index$sample26$197]);
																					int traceTempVariable$var39$200_1 = distributionTempVariable$var23$199;
																					if(((index$i$196 + 1) == (j + 1))) {
																						{
																							{
																								double cv$temp$42$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$174_1) + traceTempVariable$var35$186_1) / traceTempVariable$var39$200_1);
																									cv$temp$42$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample26Value198) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value198) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value198) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value198) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value198) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value198);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
									if(fixedFlag$sample26) {
										for(int i = 0; i < size; i += 1) {
											if(((i + 1) == j)) {
												for(int index$i$207_1 = 0; index$i$207_1 < size; index$i$207_1 += 1) {
													if(((index$i$207_1 + 1) == (j + 1))) {
														for(int index$i$214_1 = 0; index$i$214_1 < size; index$i$214_1 += 1) {
															if(((index$i$214_1 + 1) == (j + 1))) {
																{
																	{
																		double cv$temp$43$var40;
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$1_2) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]);
																			cv$temp$43$var40 = var40;
																		}
																		if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																	}
																}
															}
														}
													}
												}
											}
										}
									} else {
										for(int i = 0; i < size; i += 1) {
											if(true) {
												for(int index$sample26$203 = 0; index$sample26$203 < weightings.length; index$sample26$203 += 1) {
													int distributionTempVariable$var23$205 = index$sample26$203;
													double cv$probabilitySample26Value204 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$203]);
													int traceTempVariable$var31$206_1 = distributionTempVariable$var23$205;
													if(((i + 1) == j)) {
														int traceTempVariable$var35$208_1 = distributionTempVariable$var23$205;
														if(((i + 1) == (j + 1))) {
															int traceTempVariable$var39$215_1 = distributionTempVariable$var23$205;
															if(((i + 1) == (j + 1))) {
																{
																	{
																		double cv$temp$44$var40;
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$206_1) + traceTempVariable$var35$208_1) / traceTempVariable$var39$215_1);
																			cv$temp$44$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample26Value204) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value204) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value204) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value204) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value204) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value204);
																	}
																}
															}
															for(int index$i$216 = 0; index$i$216 < size; index$i$216 += 1) {
																if(!(index$i$216 == i)) {
																	for(int index$sample26$217 = 0; index$sample26$217 < weightings.length; index$sample26$217 += 1) {
																		int distributionTempVariable$var23$219 = index$sample26$217;
																		double cv$probabilitySample26Value218 = (cv$probabilitySample26Value204 * distribution$sample26[((index$i$216 - 0) / 1)][index$sample26$217]);
																		int traceTempVariable$var39$220_1 = distributionTempVariable$var23$219;
																		if(((index$i$216 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$45$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$206_1) + traceTempVariable$var35$208_1) / traceTempVariable$var39$220_1);
																						cv$temp$45$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value218) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value218) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value218) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value218) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value218) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value218);
																				}
																			}
																		}
																	}
																}
															}
														}
														for(int index$i$209 = 0; index$i$209 < size; index$i$209 += 1) {
															if(!(index$i$209 == i)) {
																for(int index$sample26$210 = 0; index$sample26$210 < weightings.length; index$sample26$210 += 1) {
																	int distributionTempVariable$var23$212 = index$sample26$210;
																	double cv$probabilitySample26Value211 = (cv$probabilitySample26Value204 * distribution$sample26[((index$i$209 - 0) / 1)][index$sample26$210]);
																	int traceTempVariable$var35$213_1 = distributionTempVariable$var23$212;
																	if(((index$i$209 + 1) == (j + 1))) {
																		int traceTempVariable$var39$221_1 = distributionTempVariable$var23$205;
																		if(((i + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$46$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$206_1) + traceTempVariable$var35$213_1) / traceTempVariable$var39$221_1);
																						cv$temp$46$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value211) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value211) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value211) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value211) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value211) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value211);
																				}
																			}
																		}
																		int traceTempVariable$var39$222_1 = distributionTempVariable$var23$212;
																		if(((index$i$209 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$47$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$206_1) + traceTempVariable$var35$213_1) / traceTempVariable$var39$222_1);
																						cv$temp$47$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value211) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value211) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value211) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value211) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value211) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value211);
																				}
																			}
																		}
																		for(int index$i$223 = 0; index$i$223 < size; index$i$223 += 1) {
																			if((!(index$i$223 == i) && !(index$i$223 == index$i$209))) {
																				for(int index$sample26$224 = 0; index$sample26$224 < weightings.length; index$sample26$224 += 1) {
																					int distributionTempVariable$var23$226 = index$sample26$224;
																					double cv$probabilitySample26Value225 = (cv$probabilitySample26Value211 * distribution$sample26[((index$i$223 - 0) / 1)][index$sample26$224]);
																					int traceTempVariable$var39$227_1 = distributionTempVariable$var23$226;
																					if(((index$i$223 + 1) == (j + 1))) {
																						{
																							{
																								double cv$temp$48$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$1_2) + traceTempVariable$var31$206_1) + traceTempVariable$var35$213_1) / traceTempVariable$var39$227_1);
																									cv$temp$48$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample26Value225) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value225) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value225) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value225) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value225) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value225);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
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
						}
					}
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
			cv$stateProbabilityLocal[cv$valuePos] = ((cv$stateProbabilityValue - Math.log(cv$reachedDistributionSourceRV)) + cv$accumulatedDistributionProbabilities);
		}
		double[] cv$localProbability = distribution$sample12;
		double cv$logSum = 0.0;
		{
			double cv$lseMax = cv$stateProbabilityLocal[0];
			for(int cv$lseIndex = 1; cv$lseIndex < cv$stateProbabilityLocal.length; cv$lseIndex += 1) {
				double cv$lseElementValue = cv$stateProbabilityLocal[cv$lseIndex];
				if((cv$lseMax < cv$lseElementValue))
					cv$lseMax = cv$lseElementValue;
			}
			if((cv$lseMax == Double.NEGATIVE_INFINITY))
				cv$logSum = Double.NEGATIVE_INFINITY;
			else {
				double cv$lseSum = 0.0;
				for(int cv$lseIndex = 0; cv$lseIndex < cv$stateProbabilityLocal.length; cv$lseIndex += 1)
					cv$lseSum = (cv$lseSum + Math.exp((cv$stateProbabilityLocal[cv$lseIndex] - cv$lseMax)));
				cv$logSum = (cv$logSum + (Math.log(cv$lseSum) + cv$lseMax));
			}
		}
		if((cv$logSum == Double.NEGATIVE_INFINITY)) {
			for(int cv$indexName = 0; cv$indexName < cv$stateProbabilityLocal.length; cv$indexName += 1)
				cv$localProbability[cv$indexName] = (1.0 / cv$stateProbabilityLocal.length);
		} else {
			for(int cv$indexName = 0; cv$indexName < cv$stateProbabilityLocal.length; cv$indexName += 1)
				cv$localProbability[cv$indexName] = Math.exp((cv$stateProbabilityLocal[cv$indexName] - cv$logSum));
		}
	}

	private final void sample18() {
		double[] cv$stateProbabilityLocal = cv$var15$stateProbabilityGlobal;
		for(int cv$valuePos = 0; cv$valuePos < weightings.length; cv$valuePos += 1) {
			double cv$stateProbabilityValue = Double.NEGATIVE_INFINITY;
			double cv$reachedDistributionSourceRV = 0.0;
			double cv$accumulatedDistributionProbabilities = 0.0;
			int cv$currentValue;
			cv$currentValue = cv$valuePos;
			{
				cv$reachedDistributionSourceRV = (cv$reachedDistributionSourceRV + 1.0);
				double[] cv$temp$0$weightings;
				{
					cv$temp$0$weightings = weightings;
				}
				double cv$accumulatedProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityCategorical(cv$currentValue, cv$temp$0$weightings));
				{
					{
						boolean[] guard$sample18bernoulli44 = guard$sample18bernoulli44$global;
						for(int j = 0; j < size; j += 1) {
							if((0 == j))
								guard$sample18bernoulli44[((j - 0) / 1)] = false;
						}
						for(int j = 0; j < size; j += 1) {
							if((0 == (j + 1)))
								guard$sample18bernoulli44[((j - 0) / 1)] = false;
						}
						for(int j = 0; j < size; j += 1) {
							if((0 == (j + 1)))
								guard$sample18bernoulli44[((j - 0) / 1)] = false;
						}
						int traceTempVariable$var31$4_1 = cv$currentValue;
						for(int j = 0; j < size; j += 1) {
							if((0 == j)) {
								if(!guard$sample18bernoulli44[((j - 0) / 1)]) {
									guard$sample18bernoulli44[((j - 0) / 1)] = true;
									{
										double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
										double cv$consumerDistributionProbabilityAccumulator = 1.0;
										{
											if(fixedFlag$sample12) {
												int traceTempVariable$var35$15_1 = cv$currentValue;
												if((0 == (j + 1))) {
													int traceTempVariable$var39$25_1 = cv$currentValue;
													if((0 == (j + 1))) {
														{
															{
																double cv$temp$1$var40;
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$15_1) / traceTempVariable$var39$25_1);
																	cv$temp$1$var40 = var40;
																}
																if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40)) < cv$accumulatedConsumerProbabilities))
																	cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																else {
																	if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																		cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40));
																	else
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40)));
																}
																cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
															}
														}
													}
													if(!true) {
														for(int index$sample18$26 = 0; index$sample18$26 < weightings.length; index$sample18$26 += 1) {
															int distributionTempVariable$var15$28 = index$sample18$26;
															double cv$probabilitySample18Value27 = (1.0 * distribution$sample18[index$sample18$26]);
															int traceTempVariable$var39$29_1 = distributionTempVariable$var15$28;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$2$var40;
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$15_1) / traceTempVariable$var39$29_1);
																			cv$temp$2$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample18Value27) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value27) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value27) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value27) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value27) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value27);
																	}
																}
															}
														}
													}
												}
												if(!true) {
													for(int index$sample18$16 = 0; index$sample18$16 < weightings.length; index$sample18$16 += 1) {
														int distributionTempVariable$var15$18 = index$sample18$16;
														double cv$probabilitySample18Value17 = (1.0 * distribution$sample18[index$sample18$16]);
														int traceTempVariable$var35$19_1 = distributionTempVariable$var15$18;
														if((0 == (j + 1))) {
															int traceTempVariable$var39$30_1 = cv$currentValue;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$3$var40;
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$19_1) / traceTempVariable$var39$30_1);
																			cv$temp$3$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value17);
																	}
																}
															}
															int traceTempVariable$var39$31_1 = distributionTempVariable$var15$18;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$4$var40;
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$19_1) / traceTempVariable$var39$31_1);
																			cv$temp$4$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value17) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value17);
																	}
																}
															}
															if(!true) {
																for(int index$sample18$32 = 0; index$sample18$32 < weightings.length; index$sample18$32 += 1) {
																	int distributionTempVariable$var15$34 = index$sample18$32;
																	double cv$probabilitySample18Value33 = (cv$probabilitySample18Value17 * distribution$sample18[index$sample18$32]);
																	int traceTempVariable$var39$35_1 = distributionTempVariable$var15$34;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$5$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$19_1) / traceTempVariable$var39$35_1);
																					cv$temp$5$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value33) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value33) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value33) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value33) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value33) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value33);
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$11 = 0; index$sample12$11 < weightings.length; index$sample12$11 += 1) {
														int distributionTempVariable$v1$13 = index$sample12$11;
														double cv$probabilitySample12Value12 = (1.0 * distribution$sample12[index$sample12$11]);
														int traceTempVariable$v1$14_1 = distributionTempVariable$v1$13;
														int traceTempVariable$var35$20_1 = cv$currentValue;
														if((0 == (j + 1))) {
															int traceTempVariable$var39$36_1 = cv$currentValue;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$6$var40;
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$14_1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$20_1) / traceTempVariable$var39$36_1);
																			cv$temp$6$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample12Value12) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value12) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value12) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value12) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value12) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value12);
																	}
																}
															}
															if(!true) {
																for(int index$sample18$37 = 0; index$sample18$37 < weightings.length; index$sample18$37 += 1) {
																	int distributionTempVariable$var15$39 = index$sample18$37;
																	double cv$probabilitySample18Value38 = (cv$probabilitySample12Value12 * distribution$sample18[index$sample18$37]);
																	int traceTempVariable$var39$40_1 = distributionTempVariable$var15$39;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$7$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$14_1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$20_1) / traceTempVariable$var39$40_1);
																					cv$temp$7$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value38) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value38) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value38) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value38) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value38) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value38);
																			}
																		}
																	}
																}
															}
														}
														if(!true) {
															for(int index$sample18$21 = 0; index$sample18$21 < weightings.length; index$sample18$21 += 1) {
																int distributionTempVariable$var15$23 = index$sample18$21;
																double cv$probabilitySample18Value22 = (cv$probabilitySample12Value12 * distribution$sample18[index$sample18$21]);
																int traceTempVariable$var35$24_1 = distributionTempVariable$var15$23;
																if((0 == (j + 1))) {
																	int traceTempVariable$var39$41_1 = cv$currentValue;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$8$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$14_1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$24_1) / traceTempVariable$var39$41_1);
																					cv$temp$8$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value22) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value22) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value22) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value22) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value22) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value22);
																			}
																		}
																	}
																	int traceTempVariable$var39$42_1 = distributionTempVariable$var15$23;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$9$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$14_1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$24_1) / traceTempVariable$var39$42_1);
																					cv$temp$9$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value22) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value22) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value22) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value22) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value22) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value22);
																			}
																		}
																	}
																	if(!true) {
																		for(int index$sample18$43 = 0; index$sample18$43 < weightings.length; index$sample18$43 += 1) {
																			int distributionTempVariable$var15$45 = index$sample18$43;
																			double cv$probabilitySample18Value44 = (cv$probabilitySample18Value22 * distribution$sample18[index$sample18$43]);
																			int traceTempVariable$var39$46_1 = distributionTempVariable$var15$45;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$10$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$14_1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$24_1) / traceTempVariable$var39$46_1);
																							cv$temp$10$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value44) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value44) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value44) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value44) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value44) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value44);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												if(fixedFlag$sample26) {
													for(int i = 0; i < size; i += 1) {
														if(((i + 1) == (j + 1))) {
															int traceTempVariable$var39$64_1 = cv$currentValue;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$11$var40;
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + v2[(j + 1)]) / traceTempVariable$var39$64_1);
																			cv$temp$11$var40 = var40;
																		}
																		if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																	}
																}
															}
															if(!true) {
																for(int index$sample18$65 = 0; index$sample18$65 < weightings.length; index$sample18$65 += 1) {
																	int distributionTempVariable$var15$67 = index$sample18$65;
																	double cv$probabilitySample18Value66 = (1.0 * distribution$sample18[index$sample18$65]);
																	int traceTempVariable$var39$68_1 = distributionTempVariable$var15$67;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$12$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + v2[(j + 1)]) / traceTempVariable$var39$68_1);
																					cv$temp$12$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value66) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value66) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value66) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value66) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value66) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value66);
																			}
																		}
																	}
																}
															}
														}
													}
												} else {
													for(int i = 0; i < size; i += 1) {
														if(true) {
															for(int index$sample26$54 = 0; index$sample26$54 < weightings.length; index$sample26$54 += 1) {
																int distributionTempVariable$var23$56 = index$sample26$54;
																double cv$probabilitySample26Value55 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$54]);
																int traceTempVariable$var35$57_1 = distributionTempVariable$var23$56;
																if(((i + 1) == (j + 1))) {
																	int traceTempVariable$var39$69_1 = cv$currentValue;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$13$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$57_1) / traceTempVariable$var39$69_1);
																					cv$temp$13$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value55) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value55) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value55) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value55) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value55) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value55);
																			}
																		}
																	}
																	if(!true) {
																		for(int index$sample18$70 = 0; index$sample18$70 < weightings.length; index$sample18$70 += 1) {
																			int distributionTempVariable$var15$72 = index$sample18$70;
																			double cv$probabilitySample18Value71 = (cv$probabilitySample26Value55 * distribution$sample18[index$sample18$70]);
																			int traceTempVariable$var39$73_1 = distributionTempVariable$var15$72;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$14$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$57_1) / traceTempVariable$var39$73_1);
																							cv$temp$14$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value71) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value71) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value71) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value71) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value71) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value71);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$48 = 0; index$sample12$48 < weightings.length; index$sample12$48 += 1) {
														int distributionTempVariable$v1$50 = index$sample12$48;
														double cv$probabilitySample12Value49 = (1.0 * distribution$sample12[index$sample12$48]);
														int traceTempVariable$v1$51_1 = distributionTempVariable$v1$50;
														if(fixedFlag$sample26) {
															for(int i = 0; i < size; i += 1) {
																if(((i + 1) == (j + 1))) {
																	int traceTempVariable$var39$74_1 = cv$currentValue;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$15$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$51_1) + traceTempVariable$var31$4_1) + v2[(j + 1)]) / traceTempVariable$var39$74_1);
																					cv$temp$15$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample12Value49) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value49) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value49) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value49) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value49) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value49);
																			}
																		}
																	}
																	if(!true) {
																		for(int index$sample18$75 = 0; index$sample18$75 < weightings.length; index$sample18$75 += 1) {
																			int distributionTempVariable$var15$77 = index$sample18$75;
																			double cv$probabilitySample18Value76 = (cv$probabilitySample12Value49 * distribution$sample18[index$sample18$75]);
																			int traceTempVariable$var39$78_1 = distributionTempVariable$var15$77;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$16$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$51_1) + traceTempVariable$var31$4_1) + v2[(j + 1)]) / traceTempVariable$var39$78_1);
																							cv$temp$16$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value76) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value76) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value76) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value76) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value76) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value76);
																					}
																				}
																			}
																		}
																	}
																}
															}
														} else {
															for(int i = 0; i < size; i += 1) {
																if(true) {
																	for(int index$sample26$60 = 0; index$sample26$60 < weightings.length; index$sample26$60 += 1) {
																		int distributionTempVariable$var23$62 = index$sample26$60;
																		double cv$probabilitySample26Value61 = (cv$probabilitySample12Value49 * distribution$sample26[((i - 0) / 1)][index$sample26$60]);
																		int traceTempVariable$var35$63_1 = distributionTempVariable$var23$62;
																		if(((i + 1) == (j + 1))) {
																			int traceTempVariable$var39$79_1 = cv$currentValue;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$17$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$51_1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$63_1) / traceTempVariable$var39$79_1);
																							cv$temp$17$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value61) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value61) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value61) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value61) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value61) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value61);
																					}
																				}
																			}
																			if(!true) {
																				for(int index$sample18$80 = 0; index$sample18$80 < weightings.length; index$sample18$80 += 1) {
																					int distributionTempVariable$var15$82 = index$sample18$80;
																					double cv$probabilitySample18Value81 = (cv$probabilitySample26Value61 * distribution$sample18[index$sample18$80]);
																					int traceTempVariable$var39$83_1 = distributionTempVariable$var15$82;
																					if((0 == (j + 1))) {
																						{
																							{
																								double cv$temp$18$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$51_1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$63_1) / traceTempVariable$var39$83_1);
																									cv$temp$18$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample18Value81) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value81) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value81) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value81) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value81) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value81);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												int traceTempVariable$var35$89_1 = cv$currentValue;
												if((0 == (j + 1))) {
													if(fixedFlag$sample26) {
														for(int i = 0; i < size; i += 1) {
															if(((i + 1) == (j + 1))) {
																{
																	{
																		double cv$temp$19$var40;
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$89_1) / v2[(j + 1)]);
																			cv$temp$19$var40 = var40;
																		}
																		if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																	}
																}
															}
														}
													} else {
														for(int i = 0; i < size; i += 1) {
															if(true) {
																for(int index$sample26$101 = 0; index$sample26$101 < weightings.length; index$sample26$101 += 1) {
																	int distributionTempVariable$var23$103 = index$sample26$101;
																	double cv$probabilitySample26Value102 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$101]);
																	int traceTempVariable$var39$104_1 = distributionTempVariable$var23$103;
																	if(((i + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$20$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$89_1) / traceTempVariable$var39$104_1);
																					cv$temp$20$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value102) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value102) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value102) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value102) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value102) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value102);
																			}
																		}
																	}
																}
															}
														}
													}
												}
												if(!true) {
													for(int index$sample18$90 = 0; index$sample18$90 < weightings.length; index$sample18$90 += 1) {
														int distributionTempVariable$var15$92 = index$sample18$90;
														double cv$probabilitySample18Value91 = (1.0 * distribution$sample18[index$sample18$90]);
														int traceTempVariable$var35$93_1 = distributionTempVariable$var15$92;
														if((0 == (j + 1))) {
															if(fixedFlag$sample26) {
																for(int i = 0; i < size; i += 1) {
																	if(((i + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$21$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$93_1) / v2[(j + 1)]);
																					cv$temp$21$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value91) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value91) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value91) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value91) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value91) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value91);
																			}
																		}
																	}
																}
															} else {
																for(int i = 0; i < size; i += 1) {
																	if(true) {
																		for(int index$sample26$107 = 0; index$sample26$107 < weightings.length; index$sample26$107 += 1) {
																			int distributionTempVariable$var23$109 = index$sample26$107;
																			double cv$probabilitySample26Value108 = (cv$probabilitySample18Value91 * distribution$sample26[((i - 0) / 1)][index$sample26$107]);
																			int traceTempVariable$var39$110_1 = distributionTempVariable$var23$109;
																			if(((i + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$22$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$93_1) / traceTempVariable$var39$110_1);
																							cv$temp$22$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value108) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value108) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value108) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value108) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value108) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value108);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$85 = 0; index$sample12$85 < weightings.length; index$sample12$85 += 1) {
														int distributionTempVariable$v1$87 = index$sample12$85;
														double cv$probabilitySample12Value86 = (1.0 * distribution$sample12[index$sample12$85]);
														int traceTempVariable$v1$88_1 = distributionTempVariable$v1$87;
														int traceTempVariable$var35$94_1 = cv$currentValue;
														if((0 == (j + 1))) {
															if(fixedFlag$sample26) {
																for(int i = 0; i < size; i += 1) {
																	if(((i + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$23$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$88_1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$94_1) / v2[(j + 1)]);
																					cv$temp$23$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample12Value86) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value86) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value86) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value86) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value86) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value86);
																			}
																		}
																	}
																}
															} else {
																for(int i = 0; i < size; i += 1) {
																	if(true) {
																		for(int index$sample26$113 = 0; index$sample26$113 < weightings.length; index$sample26$113 += 1) {
																			int distributionTempVariable$var23$115 = index$sample26$113;
																			double cv$probabilitySample26Value114 = (cv$probabilitySample12Value86 * distribution$sample26[((i - 0) / 1)][index$sample26$113]);
																			int traceTempVariable$var39$116_1 = distributionTempVariable$var23$115;
																			if(((i + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$24$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$88_1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$94_1) / traceTempVariable$var39$116_1);
																							cv$temp$24$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value114) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value114) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value114) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value114) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value114) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value114);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
														if(!true) {
															for(int index$sample18$95 = 0; index$sample18$95 < weightings.length; index$sample18$95 += 1) {
																int distributionTempVariable$var15$97 = index$sample18$95;
																double cv$probabilitySample18Value96 = (cv$probabilitySample12Value86 * distribution$sample18[index$sample18$95]);
																int traceTempVariable$var35$98_1 = distributionTempVariable$var15$97;
																if((0 == (j + 1))) {
																	if(fixedFlag$sample26) {
																		for(int i = 0; i < size; i += 1) {
																			if(((i + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$25$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$88_1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$98_1) / v2[(j + 1)]);
																							cv$temp$25$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value96) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value96) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value96) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value96) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value96) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value96);
																					}
																				}
																			}
																		}
																	} else {
																		for(int i = 0; i < size; i += 1) {
																			if(true) {
																				for(int index$sample26$119 = 0; index$sample26$119 < weightings.length; index$sample26$119 += 1) {
																					int distributionTempVariable$var23$121 = index$sample26$119;
																					double cv$probabilitySample26Value120 = (cv$probabilitySample18Value96 * distribution$sample26[((i - 0) / 1)][index$sample26$119]);
																					int traceTempVariable$var39$122_1 = distributionTempVariable$var23$121;
																					if(((i + 1) == (j + 1))) {
																						{
																							{
																								double cv$temp$26$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$88_1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$98_1) / traceTempVariable$var39$122_1);
																									cv$temp$26$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample26Value120) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value120) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value120) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value120) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value120) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value120);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												if(fixedFlag$sample26) {
													for(int i = 0; i < size; i += 1) {
														if(((i + 1) == (j + 1))) {
															for(int index$i$140_1 = 0; index$i$140_1 < size; index$i$140_1 += 1) {
																if(((index$i$140_1 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$27$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + v2[(j + 1)]) / v2[(j + 1)]);
																				cv$temp$27$var40 = var40;
																			}
																			if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																		}
																	}
																}
															}
														}
													}
												} else {
													for(int i = 0; i < size; i += 1) {
														if(true) {
															for(int index$sample26$130 = 0; index$sample26$130 < weightings.length; index$sample26$130 += 1) {
																int distributionTempVariable$var23$132 = index$sample26$130;
																double cv$probabilitySample26Value131 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$130]);
																int traceTempVariable$var35$133_1 = distributionTempVariable$var23$132;
																if(((i + 1) == (j + 1))) {
																	int traceTempVariable$var39$141_1 = distributionTempVariable$var23$132;
																	if(((i + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$28$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$133_1) / traceTempVariable$var39$141_1);
																					cv$temp$28$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value131) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value131) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value131) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value131) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value131) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value131);
																			}
																		}
																	}
																	for(int index$i$142 = 0; index$i$142 < size; index$i$142 += 1) {
																		if(!(index$i$142 == i)) {
																			for(int index$sample26$143 = 0; index$sample26$143 < weightings.length; index$sample26$143 += 1) {
																				int distributionTempVariable$var23$145 = index$sample26$143;
																				double cv$probabilitySample26Value144 = (cv$probabilitySample26Value131 * distribution$sample26[((index$i$142 - 0) / 1)][index$sample26$143]);
																				int traceTempVariable$var39$146_1 = distributionTempVariable$var23$145;
																				if(((index$i$142 + 1) == (j + 1))) {
																					{
																						{
																							double cv$temp$29$var40;
																							{
																								double var40 = ((((1.0 * v1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$133_1) / traceTempVariable$var39$146_1);
																								cv$temp$29$var40 = var40;
																							}
																							if(((Math.log(cv$probabilitySample26Value144) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40)) < cv$accumulatedConsumerProbabilities))
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value144) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																							else {
																								if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																									cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value144) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40));
																								else
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value144) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value144) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40)));
																							}
																							cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value144);
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$124 = 0; index$sample12$124 < weightings.length; index$sample12$124 += 1) {
														int distributionTempVariable$v1$126 = index$sample12$124;
														double cv$probabilitySample12Value125 = (1.0 * distribution$sample12[index$sample12$124]);
														int traceTempVariable$v1$127_1 = distributionTempVariable$v1$126;
														if(fixedFlag$sample26) {
															for(int i = 0; i < size; i += 1) {
																if(((i + 1) == (j + 1))) {
																	for(int index$i$147_1 = 0; index$i$147_1 < size; index$i$147_1 += 1) {
																		if(((index$i$147_1 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$30$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$127_1) + traceTempVariable$var31$4_1) + v2[(j + 1)]) / v2[(j + 1)]);
																						cv$temp$30$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample12Value125) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value125) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value125) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value125) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value125) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value125);
																				}
																			}
																		}
																	}
																}
															}
														} else {
															for(int i = 0; i < size; i += 1) {
																if(true) {
																	for(int index$sample26$136 = 0; index$sample26$136 < weightings.length; index$sample26$136 += 1) {
																		int distributionTempVariable$var23$138 = index$sample26$136;
																		double cv$probabilitySample26Value137 = (cv$probabilitySample12Value125 * distribution$sample26[((i - 0) / 1)][index$sample26$136]);
																		int traceTempVariable$var35$139_1 = distributionTempVariable$var23$138;
																		if(((i + 1) == (j + 1))) {
																			int traceTempVariable$var39$148_1 = distributionTempVariable$var23$138;
																			if(((i + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$31$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$127_1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$139_1) / traceTempVariable$var39$148_1);
																							cv$temp$31$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value137) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value137) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value137) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value137) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value137) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value137);
																					}
																				}
																			}
																			for(int index$i$149 = 0; index$i$149 < size; index$i$149 += 1) {
																				if(!(index$i$149 == i)) {
																					for(int index$sample26$150 = 0; index$sample26$150 < weightings.length; index$sample26$150 += 1) {
																						int distributionTempVariable$var23$152 = index$sample26$150;
																						double cv$probabilitySample26Value151 = (cv$probabilitySample26Value137 * distribution$sample26[((index$i$149 - 0) / 1)][index$sample26$150]);
																						int traceTempVariable$var39$153_1 = distributionTempVariable$var23$152;
																						if(((index$i$149 + 1) == (j + 1))) {
																							{
																								{
																									double cv$temp$32$var40;
																									{
																										double var40 = ((((1.0 * traceTempVariable$v1$127_1) + traceTempVariable$var31$4_1) + traceTempVariable$var35$139_1) / traceTempVariable$var39$153_1);
																										cv$temp$32$var40 = var40;
																									}
																									if(((Math.log(cv$probabilitySample26Value151) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40)) < cv$accumulatedConsumerProbabilities))
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value151) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																									else {
																										if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																											cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value151) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40));
																										else
																											cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value151) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value151) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40)));
																									}
																									cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value151);
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
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
								}
							}
						}
						int traceTempVariable$var35$5_1 = cv$currentValue;
						for(int j = 0; j < size; j += 1) {
							if((0 == (j + 1))) {
								if(!guard$sample18bernoulli44[((j - 0) / 1)]) {
									guard$sample18bernoulli44[((j - 0) / 1)] = true;
									{
										double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
										double cv$consumerDistributionProbabilityAccumulator = 1.0;
										{
											if(fixedFlag$sample12) {
												int traceTempVariable$var31$159_1 = cv$currentValue;
												if((0 == j)) {
													int traceTempVariable$var39$169_1 = cv$currentValue;
													if((0 == (j + 1))) {
														{
															{
																double cv$temp$33$var40;
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$159_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$169_1);
																	cv$temp$33$var40 = var40;
																}
																if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40)) < cv$accumulatedConsumerProbabilities))
																	cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																else {
																	if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																		cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40));
																	else
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40)));
																}
																cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
															}
														}
													}
													if(!true) {
														for(int index$sample18$170 = 0; index$sample18$170 < weightings.length; index$sample18$170 += 1) {
															int distributionTempVariable$var15$172 = index$sample18$170;
															double cv$probabilitySample18Value171 = (1.0 * distribution$sample18[index$sample18$170]);
															int traceTempVariable$var39$173_1 = distributionTempVariable$var15$172;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$34$var40;
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$159_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$173_1);
																			cv$temp$34$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample18Value171) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value171) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value171) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value171) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value171) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value171);
																	}
																}
															}
														}
													}
												}
												if(!true) {
													for(int index$sample18$160 = 0; index$sample18$160 < weightings.length; index$sample18$160 += 1) {
														int distributionTempVariable$var15$162 = index$sample18$160;
														double cv$probabilitySample18Value161 = (1.0 * distribution$sample18[index$sample18$160]);
														int traceTempVariable$var31$163_1 = distributionTempVariable$var15$162;
														if((0 == j)) {
															int traceTempVariable$var39$174_1 = cv$currentValue;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$35$var40;
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$163_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$174_1);
																			cv$temp$35$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample18Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value161);
																	}
																}
															}
															int traceTempVariable$var39$175_1 = distributionTempVariable$var15$162;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$36$var40;
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$163_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$175_1);
																			cv$temp$36$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample18Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value161) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value161);
																	}
																}
															}
															if(!true) {
																for(int index$sample18$176 = 0; index$sample18$176 < weightings.length; index$sample18$176 += 1) {
																	int distributionTempVariable$var15$178 = index$sample18$176;
																	double cv$probabilitySample18Value177 = (cv$probabilitySample18Value161 * distribution$sample18[index$sample18$176]);
																	int traceTempVariable$var39$179_1 = distributionTempVariable$var15$178;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$37$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$163_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$179_1);
																					cv$temp$37$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value177) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value177) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value177) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value177) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value177) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value177);
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$155 = 0; index$sample12$155 < weightings.length; index$sample12$155 += 1) {
														int distributionTempVariable$v1$157 = index$sample12$155;
														double cv$probabilitySample12Value156 = (1.0 * distribution$sample12[index$sample12$155]);
														int traceTempVariable$v1$158_1 = distributionTempVariable$v1$157;
														int traceTempVariable$var31$164_1 = cv$currentValue;
														if((0 == j)) {
															int traceTempVariable$var39$180_1 = cv$currentValue;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$38$var40;
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$158_1) + traceTempVariable$var31$164_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$180_1);
																			cv$temp$38$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample12Value156) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value156) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value156) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value156) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value156) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value156);
																	}
																}
															}
															if(!true) {
																for(int index$sample18$181 = 0; index$sample18$181 < weightings.length; index$sample18$181 += 1) {
																	int distributionTempVariable$var15$183 = index$sample18$181;
																	double cv$probabilitySample18Value182 = (cv$probabilitySample12Value156 * distribution$sample18[index$sample18$181]);
																	int traceTempVariable$var39$184_1 = distributionTempVariable$var15$183;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$39$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$158_1) + traceTempVariable$var31$164_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$184_1);
																					cv$temp$39$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value182) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value182) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value182) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value182) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value182) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value182);
																			}
																		}
																	}
																}
															}
														}
														if(!true) {
															for(int index$sample18$165 = 0; index$sample18$165 < weightings.length; index$sample18$165 += 1) {
																int distributionTempVariable$var15$167 = index$sample18$165;
																double cv$probabilitySample18Value166 = (cv$probabilitySample12Value156 * distribution$sample18[index$sample18$165]);
																int traceTempVariable$var31$168_1 = distributionTempVariable$var15$167;
																if((0 == j)) {
																	int traceTempVariable$var39$185_1 = cv$currentValue;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$40$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$158_1) + traceTempVariable$var31$168_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$185_1);
																					cv$temp$40$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value166) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value166) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value166) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value166) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value166) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value166);
																			}
																		}
																	}
																	int traceTempVariable$var39$186_1 = distributionTempVariable$var15$167;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$41$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$158_1) + traceTempVariable$var31$168_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$186_1);
																					cv$temp$41$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value166) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value166) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value166) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value166) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value166) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value166);
																			}
																		}
																	}
																	if(!true) {
																		for(int index$sample18$187 = 0; index$sample18$187 < weightings.length; index$sample18$187 += 1) {
																			int distributionTempVariable$var15$189 = index$sample18$187;
																			double cv$probabilitySample18Value188 = (cv$probabilitySample18Value166 * distribution$sample18[index$sample18$187]);
																			int traceTempVariable$var39$190_1 = distributionTempVariable$var15$189;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$42$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$158_1) + traceTempVariable$var31$168_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$190_1);
																							cv$temp$42$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value188) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value188) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value188) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value188) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value188) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value188);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												if(fixedFlag$sample26) {
													for(int i = 0; i < size; i += 1) {
														if(((i + 1) == j)) {
															int traceTempVariable$var39$208_1 = cv$currentValue;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$43$var40;
																		{
																			double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$5_1) / traceTempVariable$var39$208_1);
																			cv$temp$43$var40 = var40;
																		}
																		if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																	}
																}
															}
															if(!true) {
																for(int index$sample18$209 = 0; index$sample18$209 < weightings.length; index$sample18$209 += 1) {
																	int distributionTempVariable$var15$211 = index$sample18$209;
																	double cv$probabilitySample18Value210 = (1.0 * distribution$sample18[index$sample18$209]);
																	int traceTempVariable$var39$212_1 = distributionTempVariable$var15$211;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$44$var40;
																				{
																					double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$5_1) / traceTempVariable$var39$212_1);
																					cv$temp$44$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value210) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value210) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value210) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value210) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value210) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value210);
																			}
																		}
																	}
																}
															}
														}
													}
												} else {
													for(int i = 0; i < size; i += 1) {
														if(true) {
															for(int index$sample26$198 = 0; index$sample26$198 < weightings.length; index$sample26$198 += 1) {
																int distributionTempVariable$var23$200 = index$sample26$198;
																double cv$probabilitySample26Value199 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$198]);
																int traceTempVariable$var31$201_1 = distributionTempVariable$var23$200;
																if(((i + 1) == j)) {
																	int traceTempVariable$var39$213_1 = cv$currentValue;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$45$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$201_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$213_1);
																					cv$temp$45$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value199) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value199) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value199) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value199) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value199) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value199);
																			}
																		}
																	}
																	if(!true) {
																		for(int index$sample18$214 = 0; index$sample18$214 < weightings.length; index$sample18$214 += 1) {
																			int distributionTempVariable$var15$216 = index$sample18$214;
																			double cv$probabilitySample18Value215 = (cv$probabilitySample26Value199 * distribution$sample18[index$sample18$214]);
																			int traceTempVariable$var39$217_1 = distributionTempVariable$var15$216;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$46$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$201_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$217_1);
																							cv$temp$46$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value215) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value215) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value215) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value215) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value215) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value215);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$192 = 0; index$sample12$192 < weightings.length; index$sample12$192 += 1) {
														int distributionTempVariable$v1$194 = index$sample12$192;
														double cv$probabilitySample12Value193 = (1.0 * distribution$sample12[index$sample12$192]);
														int traceTempVariable$v1$195_1 = distributionTempVariable$v1$194;
														if(fixedFlag$sample26) {
															for(int i = 0; i < size; i += 1) {
																if(((i + 1) == j)) {
																	int traceTempVariable$var39$218_1 = cv$currentValue;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$47$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$195_1) + v2[j]) + traceTempVariable$var35$5_1) / traceTempVariable$var39$218_1);
																					cv$temp$47$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample12Value193) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value193) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value193) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value193) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value193) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value193);
																			}
																		}
																	}
																	if(!true) {
																		for(int index$sample18$219 = 0; index$sample18$219 < weightings.length; index$sample18$219 += 1) {
																			int distributionTempVariable$var15$221 = index$sample18$219;
																			double cv$probabilitySample18Value220 = (cv$probabilitySample12Value193 * distribution$sample18[index$sample18$219]);
																			int traceTempVariable$var39$222_1 = distributionTempVariable$var15$221;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$48$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$195_1) + v2[j]) + traceTempVariable$var35$5_1) / traceTempVariable$var39$222_1);
																							cv$temp$48$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value220) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value220) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value220) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value220) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value220) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value220);
																					}
																				}
																			}
																		}
																	}
																}
															}
														} else {
															for(int i = 0; i < size; i += 1) {
																if(true) {
																	for(int index$sample26$204 = 0; index$sample26$204 < weightings.length; index$sample26$204 += 1) {
																		int distributionTempVariable$var23$206 = index$sample26$204;
																		double cv$probabilitySample26Value205 = (cv$probabilitySample12Value193 * distribution$sample26[((i - 0) / 1)][index$sample26$204]);
																		int traceTempVariable$var31$207_1 = distributionTempVariable$var23$206;
																		if(((i + 1) == j)) {
																			int traceTempVariable$var39$223_1 = cv$currentValue;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$49$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$195_1) + traceTempVariable$var31$207_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$223_1);
																							cv$temp$49$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value205) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$49$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value205) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$49$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value205) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$49$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value205) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$49$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value205) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$49$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value205);
																					}
																				}
																			}
																			if(!true) {
																				for(int index$sample18$224 = 0; index$sample18$224 < weightings.length; index$sample18$224 += 1) {
																					int distributionTempVariable$var15$226 = index$sample18$224;
																					double cv$probabilitySample18Value225 = (cv$probabilitySample26Value205 * distribution$sample18[index$sample18$224]);
																					int traceTempVariable$var39$227_1 = distributionTempVariable$var15$226;
																					if((0 == (j + 1))) {
																						{
																							{
																								double cv$temp$50$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$195_1) + traceTempVariable$var31$207_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$227_1);
																									cv$temp$50$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample18Value225) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$50$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value225) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$50$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value225) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$50$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value225) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$50$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value225) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$50$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value225);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												int traceTempVariable$var31$233_1 = cv$currentValue;
												if((0 == j)) {
													if(fixedFlag$sample26) {
														for(int i = 0; i < size; i += 1) {
															if(((i + 1) == (j + 1))) {
																{
																	{
																		double cv$temp$51$var40;
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$233_1) + traceTempVariable$var35$5_1) / v2[(j + 1)]);
																			cv$temp$51$var40 = var40;
																		}
																		if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$51$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$51$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$51$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$51$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$51$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																	}
																}
															}
														}
													} else {
														for(int i = 0; i < size; i += 1) {
															if(true) {
																for(int index$sample26$245 = 0; index$sample26$245 < weightings.length; index$sample26$245 += 1) {
																	int distributionTempVariable$var23$247 = index$sample26$245;
																	double cv$probabilitySample26Value246 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$245]);
																	int traceTempVariable$var39$248_1 = distributionTempVariable$var23$247;
																	if(((i + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$52$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$233_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$248_1);
																					cv$temp$52$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value246) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$52$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value246) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$52$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value246) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$52$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value246) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$52$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value246) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$52$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value246);
																			}
																		}
																	}
																}
															}
														}
													}
												}
												if(!true) {
													for(int index$sample18$234 = 0; index$sample18$234 < weightings.length; index$sample18$234 += 1) {
														int distributionTempVariable$var15$236 = index$sample18$234;
														double cv$probabilitySample18Value235 = (1.0 * distribution$sample18[index$sample18$234]);
														int traceTempVariable$var31$237_1 = distributionTempVariable$var15$236;
														if((0 == j)) {
															if(fixedFlag$sample26) {
																for(int i = 0; i < size; i += 1) {
																	if(((i + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$53$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$237_1) + traceTempVariable$var35$5_1) / v2[(j + 1)]);
																					cv$temp$53$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value235) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$53$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value235) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$53$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value235) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$53$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value235) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$53$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value235) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$53$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value235);
																			}
																		}
																	}
																}
															} else {
																for(int i = 0; i < size; i += 1) {
																	if(true) {
																		for(int index$sample26$251 = 0; index$sample26$251 < weightings.length; index$sample26$251 += 1) {
																			int distributionTempVariable$var23$253 = index$sample26$251;
																			double cv$probabilitySample26Value252 = (cv$probabilitySample18Value235 * distribution$sample26[((i - 0) / 1)][index$sample26$251]);
																			int traceTempVariable$var39$254_1 = distributionTempVariable$var23$253;
																			if(((i + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$54$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$237_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$254_1);
																							cv$temp$54$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value252) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$54$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value252) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$54$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value252) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$54$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value252) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$54$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value252) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$54$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value252);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$229 = 0; index$sample12$229 < weightings.length; index$sample12$229 += 1) {
														int distributionTempVariable$v1$231 = index$sample12$229;
														double cv$probabilitySample12Value230 = (1.0 * distribution$sample12[index$sample12$229]);
														int traceTempVariable$v1$232_1 = distributionTempVariable$v1$231;
														int traceTempVariable$var31$238_1 = cv$currentValue;
														if((0 == j)) {
															if(fixedFlag$sample26) {
																for(int i = 0; i < size; i += 1) {
																	if(((i + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$55$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$232_1) + traceTempVariable$var31$238_1) + traceTempVariable$var35$5_1) / v2[(j + 1)]);
																					cv$temp$55$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample12Value230) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$55$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value230) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$55$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value230) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$55$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value230) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$55$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value230) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$55$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value230);
																			}
																		}
																	}
																}
															} else {
																for(int i = 0; i < size; i += 1) {
																	if(true) {
																		for(int index$sample26$257 = 0; index$sample26$257 < weightings.length; index$sample26$257 += 1) {
																			int distributionTempVariable$var23$259 = index$sample26$257;
																			double cv$probabilitySample26Value258 = (cv$probabilitySample12Value230 * distribution$sample26[((i - 0) / 1)][index$sample26$257]);
																			int traceTempVariable$var39$260_1 = distributionTempVariable$var23$259;
																			if(((i + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$56$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$232_1) + traceTempVariable$var31$238_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$260_1);
																							cv$temp$56$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value258) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$56$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value258) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$56$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value258) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$56$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value258) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$56$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value258) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$56$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value258);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
														if(!true) {
															for(int index$sample18$239 = 0; index$sample18$239 < weightings.length; index$sample18$239 += 1) {
																int distributionTempVariable$var15$241 = index$sample18$239;
																double cv$probabilitySample18Value240 = (cv$probabilitySample12Value230 * distribution$sample18[index$sample18$239]);
																int traceTempVariable$var31$242_1 = distributionTempVariable$var15$241;
																if((0 == j)) {
																	if(fixedFlag$sample26) {
																		for(int i = 0; i < size; i += 1) {
																			if(((i + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$57$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$232_1) + traceTempVariable$var31$242_1) + traceTempVariable$var35$5_1) / v2[(j + 1)]);
																							cv$temp$57$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value240) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$57$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value240) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$57$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value240) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$57$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value240) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$57$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value240) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$57$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value240);
																					}
																				}
																			}
																		}
																	} else {
																		for(int i = 0; i < size; i += 1) {
																			if(true) {
																				for(int index$sample26$263 = 0; index$sample26$263 < weightings.length; index$sample26$263 += 1) {
																					int distributionTempVariable$var23$265 = index$sample26$263;
																					double cv$probabilitySample26Value264 = (cv$probabilitySample18Value240 * distribution$sample26[((i - 0) / 1)][index$sample26$263]);
																					int traceTempVariable$var39$266_1 = distributionTempVariable$var23$265;
																					if(((i + 1) == (j + 1))) {
																						{
																							{
																								double cv$temp$58$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$232_1) + traceTempVariable$var31$242_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$266_1);
																									cv$temp$58$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample26Value264) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$58$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value264) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$58$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value264) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$58$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value264) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$58$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value264) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$58$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value264);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												if(fixedFlag$sample26) {
													for(int i = 0; i < size; i += 1) {
														if(((i + 1) == j)) {
															for(int index$i$284_1 = 0; index$i$284_1 < size; index$i$284_1 += 1) {
																if(((index$i$284_1 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$59$var40;
																			{
																				double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$5_1) / v2[(j + 1)]);
																				cv$temp$59$var40 = var40;
																			}
																			if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$59$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$59$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$59$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$59$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$59$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																		}
																	}
																}
															}
														}
													}
												} else {
													for(int i = 0; i < size; i += 1) {
														if(true) {
															for(int index$sample26$274 = 0; index$sample26$274 < weightings.length; index$sample26$274 += 1) {
																int distributionTempVariable$var23$276 = index$sample26$274;
																double cv$probabilitySample26Value275 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$274]);
																int traceTempVariable$var31$277_1 = distributionTempVariable$var23$276;
																if(((i + 1) == j)) {
																	int traceTempVariable$var39$285_1 = distributionTempVariable$var23$276;
																	if(((i + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$60$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$277_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$285_1);
																					cv$temp$60$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value275) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$60$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value275) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$60$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value275) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$60$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value275) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$60$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value275) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$60$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value275);
																			}
																		}
																	}
																	for(int index$i$286 = 0; index$i$286 < size; index$i$286 += 1) {
																		if(!(index$i$286 == i)) {
																			for(int index$sample26$287 = 0; index$sample26$287 < weightings.length; index$sample26$287 += 1) {
																				int distributionTempVariable$var23$289 = index$sample26$287;
																				double cv$probabilitySample26Value288 = (cv$probabilitySample26Value275 * distribution$sample26[((index$i$286 - 0) / 1)][index$sample26$287]);
																				int traceTempVariable$var39$290_1 = distributionTempVariable$var23$289;
																				if(((index$i$286 + 1) == (j + 1))) {
																					{
																						{
																							double cv$temp$61$var40;
																							{
																								double var40 = ((((1.0 * v1) + traceTempVariable$var31$277_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$290_1);
																								cv$temp$61$var40 = var40;
																							}
																							if(((Math.log(cv$probabilitySample26Value288) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$61$var40)) < cv$accumulatedConsumerProbabilities))
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value288) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$61$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																							else {
																								if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																									cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value288) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$61$var40));
																								else
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value288) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$61$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value288) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$61$var40)));
																							}
																							cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value288);
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$268 = 0; index$sample12$268 < weightings.length; index$sample12$268 += 1) {
														int distributionTempVariable$v1$270 = index$sample12$268;
														double cv$probabilitySample12Value269 = (1.0 * distribution$sample12[index$sample12$268]);
														int traceTempVariable$v1$271_1 = distributionTempVariable$v1$270;
														if(fixedFlag$sample26) {
															for(int i = 0; i < size; i += 1) {
																if(((i + 1) == j)) {
																	for(int index$i$291_1 = 0; index$i$291_1 < size; index$i$291_1 += 1) {
																		if(((index$i$291_1 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$62$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$271_1) + v2[j]) + traceTempVariable$var35$5_1) / v2[(j + 1)]);
																						cv$temp$62$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample12Value269) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$62$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value269) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$62$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value269) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$62$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value269) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$62$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value269) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$62$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value269);
																				}
																			}
																		}
																	}
																}
															}
														} else {
															for(int i = 0; i < size; i += 1) {
																if(true) {
																	for(int index$sample26$280 = 0; index$sample26$280 < weightings.length; index$sample26$280 += 1) {
																		int distributionTempVariable$var23$282 = index$sample26$280;
																		double cv$probabilitySample26Value281 = (cv$probabilitySample12Value269 * distribution$sample26[((i - 0) / 1)][index$sample26$280]);
																		int traceTempVariable$var31$283_1 = distributionTempVariable$var23$282;
																		if(((i + 1) == j)) {
																			int traceTempVariable$var39$292_1 = distributionTempVariable$var23$282;
																			if(((i + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$63$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$271_1) + traceTempVariable$var31$283_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$292_1);
																							cv$temp$63$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value281) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$63$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value281) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$63$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value281) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$63$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value281) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$63$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value281) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$63$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value281);
																					}
																				}
																			}
																			for(int index$i$293 = 0; index$i$293 < size; index$i$293 += 1) {
																				if(!(index$i$293 == i)) {
																					for(int index$sample26$294 = 0; index$sample26$294 < weightings.length; index$sample26$294 += 1) {
																						int distributionTempVariable$var23$296 = index$sample26$294;
																						double cv$probabilitySample26Value295 = (cv$probabilitySample26Value281 * distribution$sample26[((index$i$293 - 0) / 1)][index$sample26$294]);
																						int traceTempVariable$var39$297_1 = distributionTempVariable$var23$296;
																						if(((index$i$293 + 1) == (j + 1))) {
																							{
																								{
																									double cv$temp$64$var40;
																									{
																										double var40 = ((((1.0 * traceTempVariable$v1$271_1) + traceTempVariable$var31$283_1) + traceTempVariable$var35$5_1) / traceTempVariable$var39$297_1);
																										cv$temp$64$var40 = var40;
																									}
																									if(((Math.log(cv$probabilitySample26Value295) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$64$var40)) < cv$accumulatedConsumerProbabilities))
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value295) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$64$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																									else {
																										if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																											cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value295) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$64$var40));
																										else
																											cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value295) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$64$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value295) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$64$var40)));
																									}
																									cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value295);
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
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
								}
							}
						}
						int traceTempVariable$var39$6_1 = cv$currentValue;
						for(int j = 0; j < size; j += 1) {
							if((0 == (j + 1))) {
								if(!guard$sample18bernoulli44[((j - 0) / 1)]) {
									guard$sample18bernoulli44[((j - 0) / 1)] = true;
									{
										double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
										double cv$consumerDistributionProbabilityAccumulator = 1.0;
										{
											if(fixedFlag$sample12) {
												int traceTempVariable$var31$303_1 = cv$currentValue;
												if((0 == j)) {
													int traceTempVariable$var35$313_1 = cv$currentValue;
													if((0 == (j + 1))) {
														{
															{
																double cv$temp$65$var40;
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$303_1) + traceTempVariable$var35$313_1) / traceTempVariable$var39$6_1);
																	cv$temp$65$var40 = var40;
																}
																if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$65$var40)) < cv$accumulatedConsumerProbabilities))
																	cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$65$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																else {
																	if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																		cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$65$var40));
																	else
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$65$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$65$var40)));
																}
																cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
															}
														}
													}
													if(!true) {
														for(int index$sample18$314 = 0; index$sample18$314 < weightings.length; index$sample18$314 += 1) {
															int distributionTempVariable$var15$316 = index$sample18$314;
															double cv$probabilitySample18Value315 = (1.0 * distribution$sample18[index$sample18$314]);
															int traceTempVariable$var35$317_1 = distributionTempVariable$var15$316;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$66$var40;
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$303_1) + traceTempVariable$var35$317_1) / traceTempVariable$var39$6_1);
																			cv$temp$66$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample18Value315) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$66$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value315) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$66$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value315) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$66$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value315) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$66$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value315) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$66$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value315);
																	}
																}
															}
														}
													}
												}
												if(!true) {
													for(int index$sample18$304 = 0; index$sample18$304 < weightings.length; index$sample18$304 += 1) {
														int distributionTempVariable$var15$306 = index$sample18$304;
														double cv$probabilitySample18Value305 = (1.0 * distribution$sample18[index$sample18$304]);
														int traceTempVariable$var31$307_1 = distributionTempVariable$var15$306;
														if((0 == j)) {
															int traceTempVariable$var35$318_1 = cv$currentValue;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$67$var40;
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$307_1) + traceTempVariable$var35$318_1) / traceTempVariable$var39$6_1);
																			cv$temp$67$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample18Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$67$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$67$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$67$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$67$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$67$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value305);
																	}
																}
															}
															int traceTempVariable$var35$319_1 = distributionTempVariable$var15$306;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$68$var40;
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$307_1) + traceTempVariable$var35$319_1) / traceTempVariable$var39$6_1);
																			cv$temp$68$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample18Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$68$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$68$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$68$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$68$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$68$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value305);
																	}
																}
															}
															if(!true) {
																for(int index$sample18$320 = 0; index$sample18$320 < weightings.length; index$sample18$320 += 1) {
																	int distributionTempVariable$var15$322 = index$sample18$320;
																	double cv$probabilitySample18Value321 = (cv$probabilitySample18Value305 * distribution$sample18[index$sample18$320]);
																	int traceTempVariable$var35$323_1 = distributionTempVariable$var15$322;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$69$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$307_1) + traceTempVariable$var35$323_1) / traceTempVariable$var39$6_1);
																					cv$temp$69$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value321) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$69$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value321) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$69$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value321) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$69$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value321) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$69$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value321) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$69$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value321);
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$299 = 0; index$sample12$299 < weightings.length; index$sample12$299 += 1) {
														int distributionTempVariable$v1$301 = index$sample12$299;
														double cv$probabilitySample12Value300 = (1.0 * distribution$sample12[index$sample12$299]);
														int traceTempVariable$v1$302_1 = distributionTempVariable$v1$301;
														int traceTempVariable$var31$308_1 = cv$currentValue;
														if((0 == j)) {
															int traceTempVariable$var35$324_1 = cv$currentValue;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$70$var40;
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$302_1) + traceTempVariable$var31$308_1) + traceTempVariable$var35$324_1) / traceTempVariable$var39$6_1);
																			cv$temp$70$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample12Value300) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$70$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value300) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$70$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value300) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$70$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value300) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$70$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value300) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$70$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value300);
																	}
																}
															}
															if(!true) {
																for(int index$sample18$325 = 0; index$sample18$325 < weightings.length; index$sample18$325 += 1) {
																	int distributionTempVariable$var15$327 = index$sample18$325;
																	double cv$probabilitySample18Value326 = (cv$probabilitySample12Value300 * distribution$sample18[index$sample18$325]);
																	int traceTempVariable$var35$328_1 = distributionTempVariable$var15$327;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$71$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$302_1) + traceTempVariable$var31$308_1) + traceTempVariable$var35$328_1) / traceTempVariable$var39$6_1);
																					cv$temp$71$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value326) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$71$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value326) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$71$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value326) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$71$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value326) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$71$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value326) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$71$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value326);
																			}
																		}
																	}
																}
															}
														}
														if(!true) {
															for(int index$sample18$309 = 0; index$sample18$309 < weightings.length; index$sample18$309 += 1) {
																int distributionTempVariable$var15$311 = index$sample18$309;
																double cv$probabilitySample18Value310 = (cv$probabilitySample12Value300 * distribution$sample18[index$sample18$309]);
																int traceTempVariable$var31$312_1 = distributionTempVariable$var15$311;
																if((0 == j)) {
																	int traceTempVariable$var35$329_1 = cv$currentValue;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$72$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$302_1) + traceTempVariable$var31$312_1) + traceTempVariable$var35$329_1) / traceTempVariable$var39$6_1);
																					cv$temp$72$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$72$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$72$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$72$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$72$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$72$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value310);
																			}
																		}
																	}
																	int traceTempVariable$var35$330_1 = distributionTempVariable$var15$311;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$73$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$302_1) + traceTempVariable$var31$312_1) + traceTempVariable$var35$330_1) / traceTempVariable$var39$6_1);
																					cv$temp$73$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$73$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$73$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$73$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$73$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$73$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value310);
																			}
																		}
																	}
																	if(!true) {
																		for(int index$sample18$331 = 0; index$sample18$331 < weightings.length; index$sample18$331 += 1) {
																			int distributionTempVariable$var15$333 = index$sample18$331;
																			double cv$probabilitySample18Value332 = (cv$probabilitySample18Value310 * distribution$sample18[index$sample18$331]);
																			int traceTempVariable$var35$334_1 = distributionTempVariable$var15$333;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$74$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$302_1) + traceTempVariable$var31$312_1) + traceTempVariable$var35$334_1) / traceTempVariable$var39$6_1);
																							cv$temp$74$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value332) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$74$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value332) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$74$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value332) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$74$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value332) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$74$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value332) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$74$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value332);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												if(fixedFlag$sample26) {
													for(int i = 0; i < size; i += 1) {
														if(((i + 1) == j)) {
															int traceTempVariable$var35$352_1 = cv$currentValue;
															if((0 == (j + 1))) {
																{
																	{
																		double cv$temp$75$var40;
																		{
																			double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$352_1) / traceTempVariable$var39$6_1);
																			cv$temp$75$var40 = var40;
																		}
																		if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$75$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$75$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$75$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$75$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$75$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																	}
																}
															}
															if(!true) {
																for(int index$sample18$353 = 0; index$sample18$353 < weightings.length; index$sample18$353 += 1) {
																	int distributionTempVariable$var15$355 = index$sample18$353;
																	double cv$probabilitySample18Value354 = (1.0 * distribution$sample18[index$sample18$353]);
																	int traceTempVariable$var35$356_1 = distributionTempVariable$var15$355;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$76$var40;
																				{
																					double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$356_1) / traceTempVariable$var39$6_1);
																					cv$temp$76$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value354) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$76$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value354) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$76$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value354) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$76$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value354) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$76$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value354) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$76$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value354);
																			}
																		}
																	}
																}
															}
														}
													}
												} else {
													for(int i = 0; i < size; i += 1) {
														if(true) {
															for(int index$sample26$342 = 0; index$sample26$342 < weightings.length; index$sample26$342 += 1) {
																int distributionTempVariable$var23$344 = index$sample26$342;
																double cv$probabilitySample26Value343 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$342]);
																int traceTempVariable$var31$345_1 = distributionTempVariable$var23$344;
																if(((i + 1) == j)) {
																	int traceTempVariable$var35$357_1 = cv$currentValue;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$77$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$345_1) + traceTempVariable$var35$357_1) / traceTempVariable$var39$6_1);
																					cv$temp$77$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value343) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$77$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value343) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$77$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value343) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$77$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value343) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$77$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value343) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$77$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value343);
																			}
																		}
																	}
																	if(!true) {
																		for(int index$sample18$358 = 0; index$sample18$358 < weightings.length; index$sample18$358 += 1) {
																			int distributionTempVariable$var15$360 = index$sample18$358;
																			double cv$probabilitySample18Value359 = (cv$probabilitySample26Value343 * distribution$sample18[index$sample18$358]);
																			int traceTempVariable$var35$361_1 = distributionTempVariable$var15$360;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$78$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$345_1) + traceTempVariable$var35$361_1) / traceTempVariable$var39$6_1);
																							cv$temp$78$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value359) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$78$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value359) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$78$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value359) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$78$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value359) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$78$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value359) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$78$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value359);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$336 = 0; index$sample12$336 < weightings.length; index$sample12$336 += 1) {
														int distributionTempVariable$v1$338 = index$sample12$336;
														double cv$probabilitySample12Value337 = (1.0 * distribution$sample12[index$sample12$336]);
														int traceTempVariable$v1$339_1 = distributionTempVariable$v1$338;
														if(fixedFlag$sample26) {
															for(int i = 0; i < size; i += 1) {
																if(((i + 1) == j)) {
																	int traceTempVariable$var35$362_1 = cv$currentValue;
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$79$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$339_1) + v2[j]) + traceTempVariable$var35$362_1) / traceTempVariable$var39$6_1);
																					cv$temp$79$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample12Value337) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$79$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value337) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$79$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value337) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$79$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value337) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$79$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value337) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$79$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value337);
																			}
																		}
																	}
																	if(!true) {
																		for(int index$sample18$363 = 0; index$sample18$363 < weightings.length; index$sample18$363 += 1) {
																			int distributionTempVariable$var15$365 = index$sample18$363;
																			double cv$probabilitySample18Value364 = (cv$probabilitySample12Value337 * distribution$sample18[index$sample18$363]);
																			int traceTempVariable$var35$366_1 = distributionTempVariable$var15$365;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$80$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$339_1) + v2[j]) + traceTempVariable$var35$366_1) / traceTempVariable$var39$6_1);
																							cv$temp$80$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value364) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$80$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value364) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$80$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value364) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$80$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value364) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$80$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value364) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$80$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value364);
																					}
																				}
																			}
																		}
																	}
																}
															}
														} else {
															for(int i = 0; i < size; i += 1) {
																if(true) {
																	for(int index$sample26$348 = 0; index$sample26$348 < weightings.length; index$sample26$348 += 1) {
																		int distributionTempVariable$var23$350 = index$sample26$348;
																		double cv$probabilitySample26Value349 = (cv$probabilitySample12Value337 * distribution$sample26[((i - 0) / 1)][index$sample26$348]);
																		int traceTempVariable$var31$351_1 = distributionTempVariable$var23$350;
																		if(((i + 1) == j)) {
																			int traceTempVariable$var35$367_1 = cv$currentValue;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$81$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$339_1) + traceTempVariable$var31$351_1) + traceTempVariable$var35$367_1) / traceTempVariable$var39$6_1);
																							cv$temp$81$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value349) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$81$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value349) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$81$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value349) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$81$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value349) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$81$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value349) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$81$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value349);
																					}
																				}
																			}
																			if(!true) {
																				for(int index$sample18$368 = 0; index$sample18$368 < weightings.length; index$sample18$368 += 1) {
																					int distributionTempVariable$var15$370 = index$sample18$368;
																					double cv$probabilitySample18Value369 = (cv$probabilitySample26Value349 * distribution$sample18[index$sample18$368]);
																					int traceTempVariable$var35$371_1 = distributionTempVariable$var15$370;
																					if((0 == (j + 1))) {
																						{
																							{
																								double cv$temp$82$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$339_1) + traceTempVariable$var31$351_1) + traceTempVariable$var35$371_1) / traceTempVariable$var39$6_1);
																									cv$temp$82$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample18Value369) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$82$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value369) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$82$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value369) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$82$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value369) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$82$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value369) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$82$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value369);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												int traceTempVariable$var31$377_1 = cv$currentValue;
												if((0 == j)) {
													if(fixedFlag$sample26) {
														for(int i = 0; i < size; i += 1) {
															if(((i + 1) == (j + 1))) {
																{
																	{
																		double cv$temp$83$var40;
																		{
																			double var40 = ((((1.0 * v1) + traceTempVariable$var31$377_1) + v2[(j + 1)]) / traceTempVariable$var39$6_1);
																			cv$temp$83$var40 = var40;
																		}
																		if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$83$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$83$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$83$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$83$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$83$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																	}
																}
															}
														}
													} else {
														for(int i = 0; i < size; i += 1) {
															if(true) {
																for(int index$sample26$389 = 0; index$sample26$389 < weightings.length; index$sample26$389 += 1) {
																	int distributionTempVariable$var23$391 = index$sample26$389;
																	double cv$probabilitySample26Value390 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$389]);
																	int traceTempVariable$var35$392_1 = distributionTempVariable$var23$391;
																	if(((i + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$84$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$377_1) + traceTempVariable$var35$392_1) / traceTempVariable$var39$6_1);
																					cv$temp$84$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value390) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$84$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value390) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$84$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value390) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$84$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value390) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$84$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value390) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$84$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value390);
																			}
																		}
																	}
																}
															}
														}
													}
												}
												if(!true) {
													for(int index$sample18$378 = 0; index$sample18$378 < weightings.length; index$sample18$378 += 1) {
														int distributionTempVariable$var15$380 = index$sample18$378;
														double cv$probabilitySample18Value379 = (1.0 * distribution$sample18[index$sample18$378]);
														int traceTempVariable$var31$381_1 = distributionTempVariable$var15$380;
														if((0 == j)) {
															if(fixedFlag$sample26) {
																for(int i = 0; i < size; i += 1) {
																	if(((i + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$85$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$381_1) + v2[(j + 1)]) / traceTempVariable$var39$6_1);
																					cv$temp$85$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample18Value379) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$85$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value379) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$85$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value379) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$85$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value379) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$85$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value379) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$85$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value379);
																			}
																		}
																	}
																}
															} else {
																for(int i = 0; i < size; i += 1) {
																	if(true) {
																		for(int index$sample26$395 = 0; index$sample26$395 < weightings.length; index$sample26$395 += 1) {
																			int distributionTempVariable$var23$397 = index$sample26$395;
																			double cv$probabilitySample26Value396 = (cv$probabilitySample18Value379 * distribution$sample26[((i - 0) / 1)][index$sample26$395]);
																			int traceTempVariable$var35$398_1 = distributionTempVariable$var23$397;
																			if(((i + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$86$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$381_1) + traceTempVariable$var35$398_1) / traceTempVariable$var39$6_1);
																							cv$temp$86$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value396) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$86$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value396) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$86$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value396) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$86$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value396) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$86$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value396) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$86$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value396);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$373 = 0; index$sample12$373 < weightings.length; index$sample12$373 += 1) {
														int distributionTempVariable$v1$375 = index$sample12$373;
														double cv$probabilitySample12Value374 = (1.0 * distribution$sample12[index$sample12$373]);
														int traceTempVariable$v1$376_1 = distributionTempVariable$v1$375;
														int traceTempVariable$var31$382_1 = cv$currentValue;
														if((0 == j)) {
															if(fixedFlag$sample26) {
																for(int i = 0; i < size; i += 1) {
																	if(((i + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$87$var40;
																				{
																					double var40 = ((((1.0 * traceTempVariable$v1$376_1) + traceTempVariable$var31$382_1) + v2[(j + 1)]) / traceTempVariable$var39$6_1);
																					cv$temp$87$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample12Value374) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$87$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value374) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$87$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value374) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$87$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value374) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$87$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value374) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$87$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value374);
																			}
																		}
																	}
																}
															} else {
																for(int i = 0; i < size; i += 1) {
																	if(true) {
																		for(int index$sample26$401 = 0; index$sample26$401 < weightings.length; index$sample26$401 += 1) {
																			int distributionTempVariable$var23$403 = index$sample26$401;
																			double cv$probabilitySample26Value402 = (cv$probabilitySample12Value374 * distribution$sample26[((i - 0) / 1)][index$sample26$401]);
																			int traceTempVariable$var35$404_1 = distributionTempVariable$var23$403;
																			if(((i + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$88$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$376_1) + traceTempVariable$var31$382_1) + traceTempVariable$var35$404_1) / traceTempVariable$var39$6_1);
																							cv$temp$88$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value402) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$88$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value402) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$88$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value402) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$88$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value402) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$88$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value402) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$88$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value402);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
														if(!true) {
															for(int index$sample18$383 = 0; index$sample18$383 < weightings.length; index$sample18$383 += 1) {
																int distributionTempVariable$var15$385 = index$sample18$383;
																double cv$probabilitySample18Value384 = (cv$probabilitySample12Value374 * distribution$sample18[index$sample18$383]);
																int traceTempVariable$var31$386_1 = distributionTempVariable$var15$385;
																if((0 == j)) {
																	if(fixedFlag$sample26) {
																		for(int i = 0; i < size; i += 1) {
																			if(((i + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$89$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$376_1) + traceTempVariable$var31$386_1) + v2[(j + 1)]) / traceTempVariable$var39$6_1);
																							cv$temp$89$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value384) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$89$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value384) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$89$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value384) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$89$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value384) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$89$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value384) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$89$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value384);
																					}
																				}
																			}
																		}
																	} else {
																		for(int i = 0; i < size; i += 1) {
																			if(true) {
																				for(int index$sample26$407 = 0; index$sample26$407 < weightings.length; index$sample26$407 += 1) {
																					int distributionTempVariable$var23$409 = index$sample26$407;
																					double cv$probabilitySample26Value408 = (cv$probabilitySample18Value384 * distribution$sample26[((i - 0) / 1)][index$sample26$407]);
																					int traceTempVariable$var35$410_1 = distributionTempVariable$var23$409;
																					if(((i + 1) == (j + 1))) {
																						{
																							{
																								double cv$temp$90$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$376_1) + traceTempVariable$var31$386_1) + traceTempVariable$var35$410_1) / traceTempVariable$var39$6_1);
																									cv$temp$90$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample26Value408) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$90$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value408) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$90$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value408) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$90$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value408) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$90$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value408) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$90$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value408);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												if(fixedFlag$sample26) {
													for(int i = 0; i < size; i += 1) {
														if(((i + 1) == j)) {
															for(int index$i$428_1 = 0; index$i$428_1 < size; index$i$428_1 += 1) {
																if(((index$i$428_1 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$91$var40;
																			{
																				double var40 = ((((1.0 * v1) + v2[j]) + v2[(j + 1)]) / traceTempVariable$var39$6_1);
																				cv$temp$91$var40 = var40;
																			}
																			if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$91$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$91$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$91$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$91$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$91$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																		}
																	}
																}
															}
														}
													}
												} else {
													for(int i = 0; i < size; i += 1) {
														if(true) {
															for(int index$sample26$418 = 0; index$sample26$418 < weightings.length; index$sample26$418 += 1) {
																int distributionTempVariable$var23$420 = index$sample26$418;
																double cv$probabilitySample26Value419 = (1.0 * distribution$sample26[((i - 0) / 1)][index$sample26$418]);
																int traceTempVariable$var31$421_1 = distributionTempVariable$var23$420;
																if(((i + 1) == j)) {
																	int traceTempVariable$var35$429_1 = distributionTempVariable$var23$420;
																	if(((i + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$92$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$421_1) + traceTempVariable$var35$429_1) / traceTempVariable$var39$6_1);
																					cv$temp$92$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value419) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$92$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value419) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$92$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value419) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$92$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value419) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$92$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value419) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$92$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value419);
																			}
																		}
																	}
																	for(int index$i$430 = 0; index$i$430 < size; index$i$430 += 1) {
																		if(!(index$i$430 == i)) {
																			for(int index$sample26$431 = 0; index$sample26$431 < weightings.length; index$sample26$431 += 1) {
																				int distributionTempVariable$var23$433 = index$sample26$431;
																				double cv$probabilitySample26Value432 = (cv$probabilitySample26Value419 * distribution$sample26[((index$i$430 - 0) / 1)][index$sample26$431]);
																				int traceTempVariable$var35$434_1 = distributionTempVariable$var23$433;
																				if(((index$i$430 + 1) == (j + 1))) {
																					{
																						{
																							double cv$temp$93$var40;
																							{
																								double var40 = ((((1.0 * v1) + traceTempVariable$var31$421_1) + traceTempVariable$var35$434_1) / traceTempVariable$var39$6_1);
																								cv$temp$93$var40 = var40;
																							}
																							if(((Math.log(cv$probabilitySample26Value432) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$93$var40)) < cv$accumulatedConsumerProbabilities))
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value432) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$93$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																							else {
																								if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																									cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value432) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$93$var40));
																								else
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value432) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$93$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value432) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$93$var40)));
																							}
																							cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value432);
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$412 = 0; index$sample12$412 < weightings.length; index$sample12$412 += 1) {
														int distributionTempVariable$v1$414 = index$sample12$412;
														double cv$probabilitySample12Value413 = (1.0 * distribution$sample12[index$sample12$412]);
														int traceTempVariable$v1$415_1 = distributionTempVariable$v1$414;
														if(fixedFlag$sample26) {
															for(int i = 0; i < size; i += 1) {
																if(((i + 1) == j)) {
																	for(int index$i$435_1 = 0; index$i$435_1 < size; index$i$435_1 += 1) {
																		if(((index$i$435_1 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$94$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$415_1) + v2[j]) + v2[(j + 1)]) / traceTempVariable$var39$6_1);
																						cv$temp$94$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample12Value413) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$94$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value413) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$94$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value413) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$94$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value413) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$94$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value413) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$94$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value413);
																				}
																			}
																		}
																	}
																}
															}
														} else {
															for(int i = 0; i < size; i += 1) {
																if(true) {
																	for(int index$sample26$424 = 0; index$sample26$424 < weightings.length; index$sample26$424 += 1) {
																		int distributionTempVariable$var23$426 = index$sample26$424;
																		double cv$probabilitySample26Value425 = (cv$probabilitySample12Value413 * distribution$sample26[((i - 0) / 1)][index$sample26$424]);
																		int traceTempVariable$var31$427_1 = distributionTempVariable$var23$426;
																		if(((i + 1) == j)) {
																			int traceTempVariable$var35$436_1 = distributionTempVariable$var23$426;
																			if(((i + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$95$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$415_1) + traceTempVariable$var31$427_1) + traceTempVariable$var35$436_1) / traceTempVariable$var39$6_1);
																							cv$temp$95$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value425) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$95$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value425) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$95$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value425) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$95$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value425) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$95$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value425) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$95$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value425);
																					}
																				}
																			}
																			for(int index$i$437 = 0; index$i$437 < size; index$i$437 += 1) {
																				if(!(index$i$437 == i)) {
																					for(int index$sample26$438 = 0; index$sample26$438 < weightings.length; index$sample26$438 += 1) {
																						int distributionTempVariable$var23$440 = index$sample26$438;
																						double cv$probabilitySample26Value439 = (cv$probabilitySample26Value425 * distribution$sample26[((index$i$437 - 0) / 1)][index$sample26$438]);
																						int traceTempVariable$var35$441_1 = distributionTempVariable$var23$440;
																						if(((index$i$437 + 1) == (j + 1))) {
																							{
																								{
																									double cv$temp$96$var40;
																									{
																										double var40 = ((((1.0 * traceTempVariable$v1$415_1) + traceTempVariable$var31$427_1) + traceTempVariable$var35$441_1) / traceTempVariable$var39$6_1);
																										cv$temp$96$var40 = var40;
																									}
																									if(((Math.log(cv$probabilitySample26Value439) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$96$var40)) < cv$accumulatedConsumerProbabilities))
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value439) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$96$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																									else {
																										if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																											cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value439) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$96$var40));
																										else
																											cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value439) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$96$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value439) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$96$var40)));
																									}
																									cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value439);
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
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
								}
							}
						}
					}
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
			cv$stateProbabilityLocal[cv$valuePos] = ((cv$stateProbabilityValue - Math.log(cv$reachedDistributionSourceRV)) + cv$accumulatedDistributionProbabilities);
		}
		double[] cv$localProbability = distribution$sample18;
		double cv$logSum = 0.0;
		{
			double cv$lseMax = cv$stateProbabilityLocal[0];
			for(int cv$lseIndex = 1; cv$lseIndex < cv$stateProbabilityLocal.length; cv$lseIndex += 1) {
				double cv$lseElementValue = cv$stateProbabilityLocal[cv$lseIndex];
				if((cv$lseMax < cv$lseElementValue))
					cv$lseMax = cv$lseElementValue;
			}
			if((cv$lseMax == Double.NEGATIVE_INFINITY))
				cv$logSum = Double.NEGATIVE_INFINITY;
			else {
				double cv$lseSum = 0.0;
				for(int cv$lseIndex = 0; cv$lseIndex < cv$stateProbabilityLocal.length; cv$lseIndex += 1)
					cv$lseSum = (cv$lseSum + Math.exp((cv$stateProbabilityLocal[cv$lseIndex] - cv$lseMax)));
				cv$logSum = (cv$logSum + (Math.log(cv$lseSum) + cv$lseMax));
			}
		}
		if((cv$logSum == Double.NEGATIVE_INFINITY)) {
			for(int cv$indexName = 0; cv$indexName < cv$stateProbabilityLocal.length; cv$indexName += 1)
				cv$localProbability[cv$indexName] = (1.0 / cv$stateProbabilityLocal.length);
		} else {
			for(int cv$indexName = 0; cv$indexName < cv$stateProbabilityLocal.length; cv$indexName += 1)
				cv$localProbability[cv$indexName] = Math.exp((cv$stateProbabilityLocal[cv$indexName] - cv$logSum));
		}
	}

	private final void sample26(int i) {
		double[] cv$stateProbabilityLocal = cv$var23$stateProbabilityGlobal;
		for(int cv$valuePos = 0; cv$valuePos < weightings.length; cv$valuePos += 1) {
			int index$i$1 = i;
			double cv$stateProbabilityValue = Double.NEGATIVE_INFINITY;
			double cv$reachedDistributionSourceRV = 0.0;
			double cv$accumulatedDistributionProbabilities = 0.0;
			int cv$currentValue;
			cv$currentValue = cv$valuePos;
			{
				cv$reachedDistributionSourceRV = (cv$reachedDistributionSourceRV + 1.0);
				double[] cv$temp$0$weightings;
				{
					cv$temp$0$weightings = weightings;
				}
				double cv$accumulatedProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityCategorical(cv$currentValue, cv$temp$0$weightings));
				{
					{
						boolean[] guard$sample26bernoulli44 = guard$sample26bernoulli44$global;
						for(int j = 0; j < size; j += 1) {
							if(((i + 1) == j))
								guard$sample26bernoulli44[((j - 0) / 1)] = false;
						}
						for(int j = 0; j < size; j += 1) {
							if(((i + 1) == (j + 1)))
								guard$sample26bernoulli44[((j - 0) / 1)] = false;
						}
						for(int j = 0; j < size; j += 1) {
							if(((i + 1) == (j + 1)))
								guard$sample26bernoulli44[((j - 0) / 1)] = false;
						}
						int traceTempVariable$var31$5_1 = cv$currentValue;
						for(int j = 0; j < size; j += 1) {
							if(((i + 1) == j)) {
								if(!guard$sample26bernoulli44[((j - 0) / 1)]) {
									guard$sample26bernoulli44[((j - 0) / 1)] = true;
									{
										double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
										double cv$consumerDistributionProbabilityAccumulator = 1.0;
										{
											if(fixedFlag$sample12) {
												if(fixedFlag$sample18) {
													if((0 == (j + 1))) {
														if((0 == (j + 1))) {
															{
																{
																	double cv$temp$1$var40;
																	{
																		double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + v2[(j + 1)]) / v2[(j + 1)]);
																		cv$temp$1$var40 = var40;
																	}
																	if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40)) < cv$accumulatedConsumerProbabilities))
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																	else {
																		if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																			cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40));
																		else
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$1$var40)));
																	}
																	cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																}
															}
														}
													}
												} else {
													if(true) {
														for(int index$sample18$17 = 0; index$sample18$17 < weightings.length; index$sample18$17 += 1) {
															int distributionTempVariable$var15$19 = index$sample18$17;
															double cv$probabilitySample18Value18 = (1.0 * distribution$sample18[index$sample18$17]);
															int traceTempVariable$var35$20_1 = distributionTempVariable$var15$19;
															if((0 == (j + 1))) {
																int traceTempVariable$var39$27_1 = distributionTempVariable$var15$19;
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$2$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$20_1) / traceTempVariable$var39$27_1);
																				cv$temp$2$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value18) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value18) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value18) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value18) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value18) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$2$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value18);
																		}
																	}
																}
																if(!true) {
																	for(int index$sample18$28 = 0; index$sample18$28 < weightings.length; index$sample18$28 += 1) {
																		int distributionTempVariable$var15$30 = index$sample18$28;
																		double cv$probabilitySample18Value29 = (cv$probabilitySample18Value18 * distribution$sample18[index$sample18$28]);
																		int traceTempVariable$var39$31_1 = distributionTempVariable$var15$30;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$3$var40;
																					{
																						double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$20_1) / traceTempVariable$var39$31_1);
																						cv$temp$3$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value29) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value29) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value29) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value29) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value29) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$3$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value29);
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$12 = 0; index$sample12$12 < weightings.length; index$sample12$12 += 1) {
														int distributionTempVariable$v1$14 = index$sample12$12;
														double cv$probabilitySample12Value13 = (1.0 * distribution$sample12[index$sample12$12]);
														int traceTempVariable$v1$15_1 = distributionTempVariable$v1$14;
														if(fixedFlag$sample18) {
															if((0 == (j + 1))) {
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$4$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$15_1) + traceTempVariable$var31$5_1) + v2[(j + 1)]) / v2[(j + 1)]);
																				cv$temp$4$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample12Value13) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value13) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value13) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value13) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value13) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$4$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value13);
																		}
																	}
																}
															}
														} else {
															if(true) {
																for(int index$sample18$22 = 0; index$sample18$22 < weightings.length; index$sample18$22 += 1) {
																	int distributionTempVariable$var15$24 = index$sample18$22;
																	double cv$probabilitySample18Value23 = (cv$probabilitySample12Value13 * distribution$sample18[index$sample18$22]);
																	int traceTempVariable$var35$25_1 = distributionTempVariable$var15$24;
																	if((0 == (j + 1))) {
																		int traceTempVariable$var39$33_1 = distributionTempVariable$var15$24;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$5$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$15_1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$25_1) / traceTempVariable$var39$33_1);
																						cv$temp$5$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value23) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value23) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value23) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value23) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value23) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$5$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value23);
																				}
																			}
																		}
																		if(!true) {
																			for(int index$sample18$34 = 0; index$sample18$34 < weightings.length; index$sample18$34 += 1) {
																				int distributionTempVariable$var15$36 = index$sample18$34;
																				double cv$probabilitySample18Value35 = (cv$probabilitySample18Value23 * distribution$sample18[index$sample18$34]);
																				int traceTempVariable$var39$37_1 = distributionTempVariable$var15$36;
																				if((0 == (j + 1))) {
																					{
																						{
																							double cv$temp$6$var40;
																							{
																								double var40 = ((((1.0 * traceTempVariable$v1$15_1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$25_1) / traceTempVariable$var39$37_1);
																								cv$temp$6$var40 = var40;
																							}
																							if(((Math.log(cv$probabilitySample18Value35) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40)) < cv$accumulatedConsumerProbabilities))
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value35) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																							else {
																								if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																									cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value35) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40));
																								else
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value35) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value35) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$6$var40)));
																							}
																							cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value35);
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												int traceTempVariable$var35$43_1 = cv$currentValue;
												if(((index$i$1 + 1) == (j + 1))) {
													if(fixedFlag$sample18) {
														if((0 == (j + 1))) {
															{
																{
																	double cv$temp$7$var40;
																	{
																		double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$43_1) / v2[(j + 1)]);
																		cv$temp$7$var40 = var40;
																	}
																	if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40)) < cv$accumulatedConsumerProbabilities))
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																	else {
																		if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																			cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40));
																		else
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$7$var40)));
																	}
																	cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																}
															}
														}
													} else {
														if(true) {
															for(int index$sample18$56 = 0; index$sample18$56 < weightings.length; index$sample18$56 += 1) {
																int distributionTempVariable$var15$58 = index$sample18$56;
																double cv$probabilitySample18Value57 = (1.0 * distribution$sample18[index$sample18$56]);
																int traceTempVariable$var39$59_1 = distributionTempVariable$var15$58;
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$8$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$43_1) / traceTempVariable$var39$59_1);
																				cv$temp$8$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value57) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value57) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value57) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value57) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value57) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$8$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value57);
																		}
																	}
																}
															}
														}
													}
												}
												for(int index$i$44 = 0; index$i$44 < size; index$i$44 += 1) {
													if(!(index$i$44 == index$i$1)) {
														for(int index$sample26$45 = 0; index$sample26$45 < weightings.length; index$sample26$45 += 1) {
															int distributionTempVariable$var23$47 = index$sample26$45;
															double cv$probabilitySample26Value46 = (1.0 * distribution$sample26[((index$i$44 - 0) / 1)][index$sample26$45]);
															int traceTempVariable$var35$48_1 = distributionTempVariable$var23$47;
															if(((index$i$44 + 1) == (j + 1))) {
																if(fixedFlag$sample18) {
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$9$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$48_1) / v2[(j + 1)]);
																					cv$temp$9$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value46) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value46) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value46) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value46) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value46) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$9$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value46);
																			}
																		}
																	}
																} else {
																	if(true) {
																		for(int index$sample18$61 = 0; index$sample18$61 < weightings.length; index$sample18$61 += 1) {
																			int distributionTempVariable$var15$63 = index$sample18$61;
																			double cv$probabilitySample18Value62 = (cv$probabilitySample26Value46 * distribution$sample18[index$sample18$61]);
																			int traceTempVariable$var39$64_1 = distributionTempVariable$var15$63;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$10$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$48_1) / traceTempVariable$var39$64_1);
																							cv$temp$10$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value62) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value62) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value62) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value62) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value62) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$10$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value62);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$39 = 0; index$sample12$39 < weightings.length; index$sample12$39 += 1) {
														int distributionTempVariable$v1$41 = index$sample12$39;
														double cv$probabilitySample12Value40 = (1.0 * distribution$sample12[index$sample12$39]);
														int traceTempVariable$v1$42_1 = distributionTempVariable$v1$41;
														int traceTempVariable$var35$49_1 = cv$currentValue;
														if(((index$i$1 + 1) == (j + 1))) {
															if(fixedFlag$sample18) {
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$11$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$42_1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$49_1) / v2[(j + 1)]);
																				cv$temp$11$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample12Value40) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value40) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value40) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value40) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value40) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$11$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value40);
																		}
																	}
																}
															} else {
																if(true) {
																	for(int index$sample18$66 = 0; index$sample18$66 < weightings.length; index$sample18$66 += 1) {
																		int distributionTempVariable$var15$68 = index$sample18$66;
																		double cv$probabilitySample18Value67 = (cv$probabilitySample12Value40 * distribution$sample18[index$sample18$66]);
																		int traceTempVariable$var39$69_1 = distributionTempVariable$var15$68;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$12$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$42_1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$49_1) / traceTempVariable$var39$69_1);
																						cv$temp$12$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value67) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value67) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value67) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value67) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value67) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$12$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value67);
																				}
																			}
																		}
																	}
																}
															}
														}
														for(int index$i$50 = 0; index$i$50 < size; index$i$50 += 1) {
															if(!(index$i$50 == index$i$1)) {
																for(int index$sample26$51 = 0; index$sample26$51 < weightings.length; index$sample26$51 += 1) {
																	int distributionTempVariable$var23$53 = index$sample26$51;
																	double cv$probabilitySample26Value52 = (cv$probabilitySample12Value40 * distribution$sample26[((index$i$50 - 0) / 1)][index$sample26$51]);
																	int traceTempVariable$var35$54_1 = distributionTempVariable$var23$53;
																	if(((index$i$50 + 1) == (j + 1))) {
																		if(fixedFlag$sample18) {
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$13$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$42_1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$54_1) / v2[(j + 1)]);
																							cv$temp$13$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value52) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value52) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value52) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value52) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value52) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$13$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value52);
																					}
																				}
																			}
																		} else {
																			if(true) {
																				for(int index$sample18$71 = 0; index$sample18$71 < weightings.length; index$sample18$71 += 1) {
																					int distributionTempVariable$var15$73 = index$sample18$71;
																					double cv$probabilitySample18Value72 = (cv$probabilitySample26Value52 * distribution$sample18[index$sample18$71]);
																					int traceTempVariable$var39$74_1 = distributionTempVariable$var15$73;
																					if((0 == (j + 1))) {
																						{
																							{
																								double cv$temp$14$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$42_1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$54_1) / traceTempVariable$var39$74_1);
																									cv$temp$14$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample18Value72) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value72) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value72) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value72) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value72) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$14$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value72);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												if(fixedFlag$sample18) {
													if((0 == (j + 1))) {
														int traceTempVariable$var39$90_1 = cv$currentValue;
														if(((index$i$1 + 1) == (j + 1))) {
															{
																{
																	double cv$temp$15$var40;
																	{
																		double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + v2[(j + 1)]) / traceTempVariable$var39$90_1);
																		cv$temp$15$var40 = var40;
																	}
																	if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40)) < cv$accumulatedConsumerProbabilities))
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																	else {
																		if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																			cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40));
																		else
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$15$var40)));
																	}
																	cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																}
															}
														}
														for(int index$i$91 = 0; index$i$91 < size; index$i$91 += 1) {
															if(!(index$i$91 == index$i$1)) {
																for(int index$sample26$92 = 0; index$sample26$92 < weightings.length; index$sample26$92 += 1) {
																	int distributionTempVariable$var23$94 = index$sample26$92;
																	double cv$probabilitySample26Value93 = (1.0 * distribution$sample26[((index$i$91 - 0) / 1)][index$sample26$92]);
																	int traceTempVariable$var39$95_1 = distributionTempVariable$var23$94;
																	if(((index$i$91 + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$16$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + v2[(j + 1)]) / traceTempVariable$var39$95_1);
																					cv$temp$16$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value93) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value93) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value93) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value93) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value93) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$16$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value93);
																			}
																		}
																	}
																}
															}
														}
													}
												} else {
													if(true) {
														for(int index$sample18$81 = 0; index$sample18$81 < weightings.length; index$sample18$81 += 1) {
															int distributionTempVariable$var15$83 = index$sample18$81;
															double cv$probabilitySample18Value82 = (1.0 * distribution$sample18[index$sample18$81]);
															int traceTempVariable$var35$84_1 = distributionTempVariable$var15$83;
															if((0 == (j + 1))) {
																int traceTempVariable$var39$96_1 = cv$currentValue;
																if(((index$i$1 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$17$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$84_1) / traceTempVariable$var39$96_1);
																				cv$temp$17$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value82) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value82) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value82) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value82) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value82) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$17$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value82);
																		}
																	}
																}
																for(int index$i$97 = 0; index$i$97 < size; index$i$97 += 1) {
																	if(!(index$i$97 == index$i$1)) {
																		for(int index$sample26$98 = 0; index$sample26$98 < weightings.length; index$sample26$98 += 1) {
																			int distributionTempVariable$var23$100 = index$sample26$98;
																			double cv$probabilitySample26Value99 = (cv$probabilitySample18Value82 * distribution$sample26[((index$i$97 - 0) / 1)][index$sample26$98]);
																			int traceTempVariable$var39$101_1 = distributionTempVariable$var23$100;
																			if(((index$i$97 + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$18$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$84_1) / traceTempVariable$var39$101_1);
																							cv$temp$18$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value99) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value99) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value99) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value99) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value99) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$18$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value99);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$76 = 0; index$sample12$76 < weightings.length; index$sample12$76 += 1) {
														int distributionTempVariable$v1$78 = index$sample12$76;
														double cv$probabilitySample12Value77 = (1.0 * distribution$sample12[index$sample12$76]);
														int traceTempVariable$v1$79_1 = distributionTempVariable$v1$78;
														if(fixedFlag$sample18) {
															if((0 == (j + 1))) {
																int traceTempVariable$var39$102_1 = cv$currentValue;
																if(((index$i$1 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$19$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$79_1) + traceTempVariable$var31$5_1) + v2[(j + 1)]) / traceTempVariable$var39$102_1);
																				cv$temp$19$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample12Value77) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value77) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value77) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value77) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value77) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$19$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value77);
																		}
																	}
																}
																for(int index$i$103 = 0; index$i$103 < size; index$i$103 += 1) {
																	if(!(index$i$103 == index$i$1)) {
																		for(int index$sample26$104 = 0; index$sample26$104 < weightings.length; index$sample26$104 += 1) {
																			int distributionTempVariable$var23$106 = index$sample26$104;
																			double cv$probabilitySample26Value105 = (cv$probabilitySample12Value77 * distribution$sample26[((index$i$103 - 0) / 1)][index$sample26$104]);
																			int traceTempVariable$var39$107_1 = distributionTempVariable$var23$106;
																			if(((index$i$103 + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$20$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$79_1) + traceTempVariable$var31$5_1) + v2[(j + 1)]) / traceTempVariable$var39$107_1);
																							cv$temp$20$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value105) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value105) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value105) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value105) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value105) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$20$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value105);
																					}
																				}
																			}
																		}
																	}
																}
															}
														} else {
															if(true) {
																for(int index$sample18$86 = 0; index$sample18$86 < weightings.length; index$sample18$86 += 1) {
																	int distributionTempVariable$var15$88 = index$sample18$86;
																	double cv$probabilitySample18Value87 = (cv$probabilitySample12Value77 * distribution$sample18[index$sample18$86]);
																	int traceTempVariable$var35$89_1 = distributionTempVariable$var15$88;
																	if((0 == (j + 1))) {
																		int traceTempVariable$var39$108_1 = cv$currentValue;
																		if(((index$i$1 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$21$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$79_1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$89_1) / traceTempVariable$var39$108_1);
																						cv$temp$21$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value87) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value87) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value87) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value87) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value87) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$21$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value87);
																				}
																			}
																		}
																		for(int index$i$109 = 0; index$i$109 < size; index$i$109 += 1) {
																			if(!(index$i$109 == index$i$1)) {
																				for(int index$sample26$110 = 0; index$sample26$110 < weightings.length; index$sample26$110 += 1) {
																					int distributionTempVariable$var23$112 = index$sample26$110;
																					double cv$probabilitySample26Value111 = (cv$probabilitySample18Value87 * distribution$sample26[((index$i$109 - 0) / 1)][index$sample26$110]);
																					int traceTempVariable$var39$113_1 = distributionTempVariable$var23$112;
																					if(((index$i$109 + 1) == (j + 1))) {
																						{
																							{
																								double cv$temp$22$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$79_1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$89_1) / traceTempVariable$var39$113_1);
																									cv$temp$22$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample26Value111) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value111) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value111) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value111) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value111) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$22$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value111);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												int traceTempVariable$var35$119_1 = cv$currentValue;
												if(((index$i$1 + 1) == (j + 1))) {
													int traceTempVariable$var39$131_1 = cv$currentValue;
													if(((index$i$1 + 1) == (j + 1))) {
														{
															{
																double cv$temp$23$var40;
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$119_1) / traceTempVariable$var39$131_1);
																	cv$temp$23$var40 = var40;
																}
																if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40)) < cv$accumulatedConsumerProbabilities))
																	cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																else {
																	if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																		cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40));
																	else
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$23$var40)));
																}
																cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
															}
														}
													}
													for(int index$i$132 = 0; index$i$132 < size; index$i$132 += 1) {
														if(!(index$i$132 == index$i$1)) {
															for(int index$sample26$133 = 0; index$sample26$133 < weightings.length; index$sample26$133 += 1) {
																int distributionTempVariable$var23$135 = index$sample26$133;
																double cv$probabilitySample26Value134 = (1.0 * distribution$sample26[((index$i$132 - 0) / 1)][index$sample26$133]);
																int traceTempVariable$var39$136_1 = distributionTempVariable$var23$135;
																if(((index$i$132 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$24$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$119_1) / traceTempVariable$var39$136_1);
																				cv$temp$24$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value134) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value134) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value134) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value134) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value134) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$24$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value134);
																		}
																	}
																}
															}
														}
													}
												}
												for(int index$i$120 = 0; index$i$120 < size; index$i$120 += 1) {
													if(!(index$i$120 == index$i$1)) {
														for(int index$sample26$121 = 0; index$sample26$121 < weightings.length; index$sample26$121 += 1) {
															int distributionTempVariable$var23$123 = index$sample26$121;
															double cv$probabilitySample26Value122 = (1.0 * distribution$sample26[((index$i$120 - 0) / 1)][index$sample26$121]);
															int traceTempVariable$var35$124_1 = distributionTempVariable$var23$123;
															if(((index$i$120 + 1) == (j + 1))) {
																int traceTempVariable$var39$137_1 = cv$currentValue;
																if(((index$i$1 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$25$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$124_1) / traceTempVariable$var39$137_1);
																				cv$temp$25$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value122) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value122) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value122) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value122) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value122) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$25$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value122);
																		}
																	}
																}
																int traceTempVariable$var39$138_1 = distributionTempVariable$var23$123;
																if(((index$i$120 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$26$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$124_1) / traceTempVariable$var39$138_1);
																				cv$temp$26$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value122) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value122) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value122) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value122) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value122) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$26$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value122);
																		}
																	}
																}
																for(int index$i$139 = 0; index$i$139 < size; index$i$139 += 1) {
																	if((!(index$i$139 == index$i$1) && !(index$i$139 == index$i$120))) {
																		for(int index$sample26$140 = 0; index$sample26$140 < weightings.length; index$sample26$140 += 1) {
																			int distributionTempVariable$var23$142 = index$sample26$140;
																			double cv$probabilitySample26Value141 = (cv$probabilitySample26Value122 * distribution$sample26[((index$i$139 - 0) / 1)][index$sample26$140]);
																			int traceTempVariable$var39$143_1 = distributionTempVariable$var23$142;
																			if(((index$i$139 + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$27$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$124_1) / traceTempVariable$var39$143_1);
																							cv$temp$27$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value141) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value141) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value141) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value141) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value141) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$27$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value141);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$115 = 0; index$sample12$115 < weightings.length; index$sample12$115 += 1) {
														int distributionTempVariable$v1$117 = index$sample12$115;
														double cv$probabilitySample12Value116 = (1.0 * distribution$sample12[index$sample12$115]);
														int traceTempVariable$v1$118_1 = distributionTempVariable$v1$117;
														int traceTempVariable$var35$125_1 = cv$currentValue;
														if(((index$i$1 + 1) == (j + 1))) {
															int traceTempVariable$var39$144_1 = cv$currentValue;
															if(((index$i$1 + 1) == (j + 1))) {
																{
																	{
																		double cv$temp$28$var40;
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$118_1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$125_1) / traceTempVariable$var39$144_1);
																			cv$temp$28$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample12Value116) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value116) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value116) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value116) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value116) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$28$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value116);
																	}
																}
															}
															for(int index$i$145 = 0; index$i$145 < size; index$i$145 += 1) {
																if(!(index$i$145 == index$i$1)) {
																	for(int index$sample26$146 = 0; index$sample26$146 < weightings.length; index$sample26$146 += 1) {
																		int distributionTempVariable$var23$148 = index$sample26$146;
																		double cv$probabilitySample26Value147 = (cv$probabilitySample12Value116 * distribution$sample26[((index$i$145 - 0) / 1)][index$sample26$146]);
																		int traceTempVariable$var39$149_1 = distributionTempVariable$var23$148;
																		if(((index$i$145 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$29$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$118_1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$125_1) / traceTempVariable$var39$149_1);
																						cv$temp$29$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value147) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value147) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value147) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value147) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value147) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$29$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value147);
																				}
																			}
																		}
																	}
																}
															}
														}
														for(int index$i$126 = 0; index$i$126 < size; index$i$126 += 1) {
															if(!(index$i$126 == index$i$1)) {
																for(int index$sample26$127 = 0; index$sample26$127 < weightings.length; index$sample26$127 += 1) {
																	int distributionTempVariable$var23$129 = index$sample26$127;
																	double cv$probabilitySample26Value128 = (cv$probabilitySample12Value116 * distribution$sample26[((index$i$126 - 0) / 1)][index$sample26$127]);
																	int traceTempVariable$var35$130_1 = distributionTempVariable$var23$129;
																	if(((index$i$126 + 1) == (j + 1))) {
																		int traceTempVariable$var39$150_1 = cv$currentValue;
																		if(((index$i$1 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$30$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$118_1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$130_1) / traceTempVariable$var39$150_1);
																						cv$temp$30$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value128) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value128) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value128) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value128) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value128) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$30$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value128);
																				}
																			}
																		}
																		int traceTempVariable$var39$151_1 = distributionTempVariable$var23$129;
																		if(((index$i$126 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$31$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$118_1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$130_1) / traceTempVariable$var39$151_1);
																						cv$temp$31$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value128) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value128) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value128) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value128) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value128) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$31$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value128);
																				}
																			}
																		}
																		for(int index$i$152 = 0; index$i$152 < size; index$i$152 += 1) {
																			if((!(index$i$152 == index$i$1) && !(index$i$152 == index$i$126))) {
																				for(int index$sample26$153 = 0; index$sample26$153 < weightings.length; index$sample26$153 += 1) {
																					int distributionTempVariable$var23$155 = index$sample26$153;
																					double cv$probabilitySample26Value154 = (cv$probabilitySample26Value128 * distribution$sample26[((index$i$152 - 0) / 1)][index$sample26$153]);
																					int traceTempVariable$var39$156_1 = distributionTempVariable$var23$155;
																					if(((index$i$152 + 1) == (j + 1))) {
																						{
																							{
																								double cv$temp$32$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$118_1) + traceTempVariable$var31$5_1) + traceTempVariable$var35$130_1) / traceTempVariable$var39$156_1);
																									cv$temp$32$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample26Value154) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value154) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value154) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value154) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value154) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$32$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value154);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
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
								}
							}
						}
						int traceTempVariable$var35$6_1 = cv$currentValue;
						for(int j = 0; j < size; j += 1) {
							if(((i + 1) == (j + 1))) {
								if(!guard$sample26bernoulli44[((j - 0) / 1)]) {
									guard$sample26bernoulli44[((j - 0) / 1)] = true;
									{
										double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
										double cv$consumerDistributionProbabilityAccumulator = 1.0;
										{
											if(fixedFlag$sample12) {
												if(fixedFlag$sample18) {
													if((0 == j)) {
														if((0 == (j + 1))) {
															{
																{
																	double cv$temp$33$var40;
																	{
																		double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$6_1) / v2[(j + 1)]);
																		cv$temp$33$var40 = var40;
																	}
																	if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40)) < cv$accumulatedConsumerProbabilities))
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																	else {
																		if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																			cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40));
																		else
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$33$var40)));
																	}
																	cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																}
															}
														}
													}
												} else {
													if(true) {
														for(int index$sample18$163 = 0; index$sample18$163 < weightings.length; index$sample18$163 += 1) {
															int distributionTempVariable$var15$165 = index$sample18$163;
															double cv$probabilitySample18Value164 = (1.0 * distribution$sample18[index$sample18$163]);
															int traceTempVariable$var31$166_1 = distributionTempVariable$var15$165;
															if((0 == j)) {
																int traceTempVariable$var39$173_1 = distributionTempVariable$var15$165;
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$34$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$166_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$173_1);
																				cv$temp$34$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value164) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value164) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value164) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value164) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value164) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$34$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value164);
																		}
																	}
																}
																if(!true) {
																	for(int index$sample18$174 = 0; index$sample18$174 < weightings.length; index$sample18$174 += 1) {
																		int distributionTempVariable$var15$176 = index$sample18$174;
																		double cv$probabilitySample18Value175 = (cv$probabilitySample18Value164 * distribution$sample18[index$sample18$174]);
																		int traceTempVariable$var39$177_1 = distributionTempVariable$var15$176;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$35$var40;
																					{
																						double var40 = ((((1.0 * v1) + traceTempVariable$var31$166_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$177_1);
																						cv$temp$35$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value175) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value175) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value175) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value175) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value175) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$35$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value175);
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$158 = 0; index$sample12$158 < weightings.length; index$sample12$158 += 1) {
														int distributionTempVariable$v1$160 = index$sample12$158;
														double cv$probabilitySample12Value159 = (1.0 * distribution$sample12[index$sample12$158]);
														int traceTempVariable$v1$161_1 = distributionTempVariable$v1$160;
														if(fixedFlag$sample18) {
															if((0 == j)) {
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$36$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$161_1) + v2[j]) + traceTempVariable$var35$6_1) / v2[(j + 1)]);
																				cv$temp$36$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample12Value159) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value159) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value159) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value159) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value159) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$36$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value159);
																		}
																	}
																}
															}
														} else {
															if(true) {
																for(int index$sample18$168 = 0; index$sample18$168 < weightings.length; index$sample18$168 += 1) {
																	int distributionTempVariable$var15$170 = index$sample18$168;
																	double cv$probabilitySample18Value169 = (cv$probabilitySample12Value159 * distribution$sample18[index$sample18$168]);
																	int traceTempVariable$var31$171_1 = distributionTempVariable$var15$170;
																	if((0 == j)) {
																		int traceTempVariable$var39$179_1 = distributionTempVariable$var15$170;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$37$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$161_1) + traceTempVariable$var31$171_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$179_1);
																						cv$temp$37$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value169) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value169) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value169) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value169) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value169) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$37$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value169);
																				}
																			}
																		}
																		if(!true) {
																			for(int index$sample18$180 = 0; index$sample18$180 < weightings.length; index$sample18$180 += 1) {
																				int distributionTempVariable$var15$182 = index$sample18$180;
																				double cv$probabilitySample18Value181 = (cv$probabilitySample18Value169 * distribution$sample18[index$sample18$180]);
																				int traceTempVariable$var39$183_1 = distributionTempVariable$var15$182;
																				if((0 == (j + 1))) {
																					{
																						{
																							double cv$temp$38$var40;
																							{
																								double var40 = ((((1.0 * traceTempVariable$v1$161_1) + traceTempVariable$var31$171_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$183_1);
																								cv$temp$38$var40 = var40;
																							}
																							if(((Math.log(cv$probabilitySample18Value181) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40)) < cv$accumulatedConsumerProbabilities))
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value181) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																							else {
																								if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																									cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value181) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40));
																								else
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value181) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value181) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$38$var40)));
																							}
																							cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value181);
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												int traceTempVariable$var31$189_1 = cv$currentValue;
												if(((index$i$1 + 1) == j)) {
													if(fixedFlag$sample18) {
														if((0 == (j + 1))) {
															{
																{
																	double cv$temp$39$var40;
																	{
																		double var40 = ((((1.0 * v1) + traceTempVariable$var31$189_1) + traceTempVariable$var35$6_1) / v2[(j + 1)]);
																		cv$temp$39$var40 = var40;
																	}
																	if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40)) < cv$accumulatedConsumerProbabilities))
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																	else {
																		if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																			cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40));
																		else
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$39$var40)));
																	}
																	cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																}
															}
														}
													} else {
														if(true) {
															for(int index$sample18$202 = 0; index$sample18$202 < weightings.length; index$sample18$202 += 1) {
																int distributionTempVariable$var15$204 = index$sample18$202;
																double cv$probabilitySample18Value203 = (1.0 * distribution$sample18[index$sample18$202]);
																int traceTempVariable$var39$205_1 = distributionTempVariable$var15$204;
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$40$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$189_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$205_1);
																				cv$temp$40$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value203) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value203) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value203) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value203) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value203) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$40$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value203);
																		}
																	}
																}
															}
														}
													}
												}
												for(int index$i$190 = 0; index$i$190 < size; index$i$190 += 1) {
													if(!(index$i$190 == index$i$1)) {
														for(int index$sample26$191 = 0; index$sample26$191 < weightings.length; index$sample26$191 += 1) {
															int distributionTempVariable$var23$193 = index$sample26$191;
															double cv$probabilitySample26Value192 = (1.0 * distribution$sample26[((index$i$190 - 0) / 1)][index$sample26$191]);
															int traceTempVariable$var31$194_1 = distributionTempVariable$var23$193;
															if(((index$i$190 + 1) == j)) {
																if(fixedFlag$sample18) {
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$41$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$194_1) + traceTempVariable$var35$6_1) / v2[(j + 1)]);
																					cv$temp$41$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value192) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value192) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value192) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value192) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value192) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$41$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value192);
																			}
																		}
																	}
																} else {
																	if(true) {
																		for(int index$sample18$207 = 0; index$sample18$207 < weightings.length; index$sample18$207 += 1) {
																			int distributionTempVariable$var15$209 = index$sample18$207;
																			double cv$probabilitySample18Value208 = (cv$probabilitySample26Value192 * distribution$sample18[index$sample18$207]);
																			int traceTempVariable$var39$210_1 = distributionTempVariable$var15$209;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$42$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$194_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$210_1);
																							cv$temp$42$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value208) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value208) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value208) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value208) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value208) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$42$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value208);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$185 = 0; index$sample12$185 < weightings.length; index$sample12$185 += 1) {
														int distributionTempVariable$v1$187 = index$sample12$185;
														double cv$probabilitySample12Value186 = (1.0 * distribution$sample12[index$sample12$185]);
														int traceTempVariable$v1$188_1 = distributionTempVariable$v1$187;
														int traceTempVariable$var31$195_1 = cv$currentValue;
														if(((index$i$1 + 1) == j)) {
															if(fixedFlag$sample18) {
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$43$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$188_1) + traceTempVariable$var31$195_1) + traceTempVariable$var35$6_1) / v2[(j + 1)]);
																				cv$temp$43$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample12Value186) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value186) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value186) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value186) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value186) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$43$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value186);
																		}
																	}
																}
															} else {
																if(true) {
																	for(int index$sample18$212 = 0; index$sample18$212 < weightings.length; index$sample18$212 += 1) {
																		int distributionTempVariable$var15$214 = index$sample18$212;
																		double cv$probabilitySample18Value213 = (cv$probabilitySample12Value186 * distribution$sample18[index$sample18$212]);
																		int traceTempVariable$var39$215_1 = distributionTempVariable$var15$214;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$44$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$188_1) + traceTempVariable$var31$195_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$215_1);
																						cv$temp$44$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value213) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value213) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value213) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value213) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value213) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$44$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value213);
																				}
																			}
																		}
																	}
																}
															}
														}
														for(int index$i$196 = 0; index$i$196 < size; index$i$196 += 1) {
															if(!(index$i$196 == index$i$1)) {
																for(int index$sample26$197 = 0; index$sample26$197 < weightings.length; index$sample26$197 += 1) {
																	int distributionTempVariable$var23$199 = index$sample26$197;
																	double cv$probabilitySample26Value198 = (cv$probabilitySample12Value186 * distribution$sample26[((index$i$196 - 0) / 1)][index$sample26$197]);
																	int traceTempVariable$var31$200_1 = distributionTempVariable$var23$199;
																	if(((index$i$196 + 1) == j)) {
																		if(fixedFlag$sample18) {
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$45$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$188_1) + traceTempVariable$var31$200_1) + traceTempVariable$var35$6_1) / v2[(j + 1)]);
																							cv$temp$45$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value198) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value198) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value198) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value198) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value198) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$45$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value198);
																					}
																				}
																			}
																		} else {
																			if(true) {
																				for(int index$sample18$217 = 0; index$sample18$217 < weightings.length; index$sample18$217 += 1) {
																					int distributionTempVariable$var15$219 = index$sample18$217;
																					double cv$probabilitySample18Value218 = (cv$probabilitySample26Value198 * distribution$sample18[index$sample18$217]);
																					int traceTempVariable$var39$220_1 = distributionTempVariable$var15$219;
																					if((0 == (j + 1))) {
																						{
																							{
																								double cv$temp$46$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$188_1) + traceTempVariable$var31$200_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$220_1);
																									cv$temp$46$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample18Value218) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value218) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value218) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value218) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value218) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$46$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value218);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												if(fixedFlag$sample18) {
													if((0 == j)) {
														int traceTempVariable$var39$236_1 = cv$currentValue;
														if(((index$i$1 + 1) == (j + 1))) {
															{
																{
																	double cv$temp$47$var40;
																	{
																		double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$6_1) / traceTempVariable$var39$236_1);
																		cv$temp$47$var40 = var40;
																	}
																	if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40)) < cv$accumulatedConsumerProbabilities))
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																	else {
																		if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																			cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40));
																		else
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$47$var40)));
																	}
																	cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																}
															}
														}
														for(int index$i$237 = 0; index$i$237 < size; index$i$237 += 1) {
															if(!(index$i$237 == index$i$1)) {
																for(int index$sample26$238 = 0; index$sample26$238 < weightings.length; index$sample26$238 += 1) {
																	int distributionTempVariable$var23$240 = index$sample26$238;
																	double cv$probabilitySample26Value239 = (1.0 * distribution$sample26[((index$i$237 - 0) / 1)][index$sample26$238]);
																	int traceTempVariable$var39$241_1 = distributionTempVariable$var23$240;
																	if(((index$i$237 + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$48$var40;
																				{
																					double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$6_1) / traceTempVariable$var39$241_1);
																					cv$temp$48$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value239) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value239) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value239) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value239) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value239) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$48$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value239);
																			}
																		}
																	}
																}
															}
														}
													}
												} else {
													if(true) {
														for(int index$sample18$227 = 0; index$sample18$227 < weightings.length; index$sample18$227 += 1) {
															int distributionTempVariable$var15$229 = index$sample18$227;
															double cv$probabilitySample18Value228 = (1.0 * distribution$sample18[index$sample18$227]);
															int traceTempVariable$var31$230_1 = distributionTempVariable$var15$229;
															if((0 == j)) {
																int traceTempVariable$var39$242_1 = cv$currentValue;
																if(((index$i$1 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$49$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$230_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$242_1);
																				cv$temp$49$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value228) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$49$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value228) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$49$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value228) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$49$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value228) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$49$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value228) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$49$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value228);
																		}
																	}
																}
																for(int index$i$243 = 0; index$i$243 < size; index$i$243 += 1) {
																	if(!(index$i$243 == index$i$1)) {
																		for(int index$sample26$244 = 0; index$sample26$244 < weightings.length; index$sample26$244 += 1) {
																			int distributionTempVariable$var23$246 = index$sample26$244;
																			double cv$probabilitySample26Value245 = (cv$probabilitySample18Value228 * distribution$sample26[((index$i$243 - 0) / 1)][index$sample26$244]);
																			int traceTempVariable$var39$247_1 = distributionTempVariable$var23$246;
																			if(((index$i$243 + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$50$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$230_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$247_1);
																							cv$temp$50$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value245) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$50$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value245) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$50$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value245) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$50$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value245) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$50$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value245) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$50$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value245);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$222 = 0; index$sample12$222 < weightings.length; index$sample12$222 += 1) {
														int distributionTempVariable$v1$224 = index$sample12$222;
														double cv$probabilitySample12Value223 = (1.0 * distribution$sample12[index$sample12$222]);
														int traceTempVariable$v1$225_1 = distributionTempVariable$v1$224;
														if(fixedFlag$sample18) {
															if((0 == j)) {
																int traceTempVariable$var39$248_1 = cv$currentValue;
																if(((index$i$1 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$51$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$225_1) + v2[j]) + traceTempVariable$var35$6_1) / traceTempVariable$var39$248_1);
																				cv$temp$51$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample12Value223) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$51$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value223) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$51$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value223) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$51$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value223) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$51$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value223) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$51$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value223);
																		}
																	}
																}
																for(int index$i$249 = 0; index$i$249 < size; index$i$249 += 1) {
																	if(!(index$i$249 == index$i$1)) {
																		for(int index$sample26$250 = 0; index$sample26$250 < weightings.length; index$sample26$250 += 1) {
																			int distributionTempVariable$var23$252 = index$sample26$250;
																			double cv$probabilitySample26Value251 = (cv$probabilitySample12Value223 * distribution$sample26[((index$i$249 - 0) / 1)][index$sample26$250]);
																			int traceTempVariable$var39$253_1 = distributionTempVariable$var23$252;
																			if(((index$i$249 + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$52$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$225_1) + v2[j]) + traceTempVariable$var35$6_1) / traceTempVariable$var39$253_1);
																							cv$temp$52$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value251) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$52$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value251) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$52$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value251) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$52$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value251) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$52$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value251) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$52$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value251);
																					}
																				}
																			}
																		}
																	}
																}
															}
														} else {
															if(true) {
																for(int index$sample18$232 = 0; index$sample18$232 < weightings.length; index$sample18$232 += 1) {
																	int distributionTempVariable$var15$234 = index$sample18$232;
																	double cv$probabilitySample18Value233 = (cv$probabilitySample12Value223 * distribution$sample18[index$sample18$232]);
																	int traceTempVariable$var31$235_1 = distributionTempVariable$var15$234;
																	if((0 == j)) {
																		int traceTempVariable$var39$254_1 = cv$currentValue;
																		if(((index$i$1 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$53$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$225_1) + traceTempVariable$var31$235_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$254_1);
																						cv$temp$53$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value233) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$53$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value233) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$53$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value233) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$53$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value233) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$53$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value233) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$53$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value233);
																				}
																			}
																		}
																		for(int index$i$255 = 0; index$i$255 < size; index$i$255 += 1) {
																			if(!(index$i$255 == index$i$1)) {
																				for(int index$sample26$256 = 0; index$sample26$256 < weightings.length; index$sample26$256 += 1) {
																					int distributionTempVariable$var23$258 = index$sample26$256;
																					double cv$probabilitySample26Value257 = (cv$probabilitySample18Value233 * distribution$sample26[((index$i$255 - 0) / 1)][index$sample26$256]);
																					int traceTempVariable$var39$259_1 = distributionTempVariable$var23$258;
																					if(((index$i$255 + 1) == (j + 1))) {
																						{
																							{
																								double cv$temp$54$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$225_1) + traceTempVariable$var31$235_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$259_1);
																									cv$temp$54$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample26Value257) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$54$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value257) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$54$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value257) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$54$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value257) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$54$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value257) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$54$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value257);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												int traceTempVariable$var31$265_1 = cv$currentValue;
												if(((index$i$1 + 1) == j)) {
													int traceTempVariable$var39$277_1 = cv$currentValue;
													if(((index$i$1 + 1) == (j + 1))) {
														{
															{
																double cv$temp$55$var40;
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$265_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$277_1);
																	cv$temp$55$var40 = var40;
																}
																if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$55$var40)) < cv$accumulatedConsumerProbabilities))
																	cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$55$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																else {
																	if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																		cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$55$var40));
																	else
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$55$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$55$var40)));
																}
																cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
															}
														}
													}
													for(int index$i$278 = 0; index$i$278 < size; index$i$278 += 1) {
														if(!(index$i$278 == index$i$1)) {
															for(int index$sample26$279 = 0; index$sample26$279 < weightings.length; index$sample26$279 += 1) {
																int distributionTempVariable$var23$281 = index$sample26$279;
																double cv$probabilitySample26Value280 = (1.0 * distribution$sample26[((index$i$278 - 0) / 1)][index$sample26$279]);
																int traceTempVariable$var39$282_1 = distributionTempVariable$var23$281;
																if(((index$i$278 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$56$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$265_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$282_1);
																				cv$temp$56$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value280) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$56$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value280) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$56$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value280) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$56$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value280) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$56$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value280) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$56$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value280);
																		}
																	}
																}
															}
														}
													}
												}
												for(int index$i$266 = 0; index$i$266 < size; index$i$266 += 1) {
													if(!(index$i$266 == index$i$1)) {
														for(int index$sample26$267 = 0; index$sample26$267 < weightings.length; index$sample26$267 += 1) {
															int distributionTempVariable$var23$269 = index$sample26$267;
															double cv$probabilitySample26Value268 = (1.0 * distribution$sample26[((index$i$266 - 0) / 1)][index$sample26$267]);
															int traceTempVariable$var31$270_1 = distributionTempVariable$var23$269;
															if(((index$i$266 + 1) == j)) {
																int traceTempVariable$var39$283_1 = cv$currentValue;
																if(((index$i$1 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$57$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$270_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$283_1);
																				cv$temp$57$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value268) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$57$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value268) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$57$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value268) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$57$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value268) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$57$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value268) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$57$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value268);
																		}
																	}
																}
																int traceTempVariable$var39$284_1 = distributionTempVariable$var23$269;
																if(((index$i$266 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$58$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$270_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$284_1);
																				cv$temp$58$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value268) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$58$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value268) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$58$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value268) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$58$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value268) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$58$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value268) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$58$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value268);
																		}
																	}
																}
																for(int index$i$285 = 0; index$i$285 < size; index$i$285 += 1) {
																	if((!(index$i$285 == index$i$1) && !(index$i$285 == index$i$266))) {
																		for(int index$sample26$286 = 0; index$sample26$286 < weightings.length; index$sample26$286 += 1) {
																			int distributionTempVariable$var23$288 = index$sample26$286;
																			double cv$probabilitySample26Value287 = (cv$probabilitySample26Value268 * distribution$sample26[((index$i$285 - 0) / 1)][index$sample26$286]);
																			int traceTempVariable$var39$289_1 = distributionTempVariable$var23$288;
																			if(((index$i$285 + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$59$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$270_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$289_1);
																							cv$temp$59$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value287) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$59$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value287) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$59$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value287) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$59$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value287) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$59$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value287) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$59$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value287);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$261 = 0; index$sample12$261 < weightings.length; index$sample12$261 += 1) {
														int distributionTempVariable$v1$263 = index$sample12$261;
														double cv$probabilitySample12Value262 = (1.0 * distribution$sample12[index$sample12$261]);
														int traceTempVariable$v1$264_1 = distributionTempVariable$v1$263;
														int traceTempVariable$var31$271_1 = cv$currentValue;
														if(((index$i$1 + 1) == j)) {
															int traceTempVariable$var39$290_1 = cv$currentValue;
															if(((index$i$1 + 1) == (j + 1))) {
																{
																	{
																		double cv$temp$60$var40;
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$264_1) + traceTempVariable$var31$271_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$290_1);
																			cv$temp$60$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample12Value262) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$60$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value262) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$60$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value262) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$60$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value262) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$60$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value262) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$60$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value262);
																	}
																}
															}
															for(int index$i$291 = 0; index$i$291 < size; index$i$291 += 1) {
																if(!(index$i$291 == index$i$1)) {
																	for(int index$sample26$292 = 0; index$sample26$292 < weightings.length; index$sample26$292 += 1) {
																		int distributionTempVariable$var23$294 = index$sample26$292;
																		double cv$probabilitySample26Value293 = (cv$probabilitySample12Value262 * distribution$sample26[((index$i$291 - 0) / 1)][index$sample26$292]);
																		int traceTempVariable$var39$295_1 = distributionTempVariable$var23$294;
																		if(((index$i$291 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$61$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$264_1) + traceTempVariable$var31$271_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$295_1);
																						cv$temp$61$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value293) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$61$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value293) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$61$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value293) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$61$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value293) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$61$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value293) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$61$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value293);
																				}
																			}
																		}
																	}
																}
															}
														}
														for(int index$i$272 = 0; index$i$272 < size; index$i$272 += 1) {
															if(!(index$i$272 == index$i$1)) {
																for(int index$sample26$273 = 0; index$sample26$273 < weightings.length; index$sample26$273 += 1) {
																	int distributionTempVariable$var23$275 = index$sample26$273;
																	double cv$probabilitySample26Value274 = (cv$probabilitySample12Value262 * distribution$sample26[((index$i$272 - 0) / 1)][index$sample26$273]);
																	int traceTempVariable$var31$276_1 = distributionTempVariable$var23$275;
																	if(((index$i$272 + 1) == j)) {
																		int traceTempVariable$var39$296_1 = cv$currentValue;
																		if(((index$i$1 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$62$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$264_1) + traceTempVariable$var31$276_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$296_1);
																						cv$temp$62$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value274) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$62$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value274) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$62$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value274) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$62$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value274) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$62$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value274) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$62$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value274);
																				}
																			}
																		}
																		int traceTempVariable$var39$297_1 = distributionTempVariable$var23$275;
																		if(((index$i$272 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$63$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$264_1) + traceTempVariable$var31$276_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$297_1);
																						cv$temp$63$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value274) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$63$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value274) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$63$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value274) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$63$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value274) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$63$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value274) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$63$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value274);
																				}
																			}
																		}
																		for(int index$i$298 = 0; index$i$298 < size; index$i$298 += 1) {
																			if((!(index$i$298 == index$i$1) && !(index$i$298 == index$i$272))) {
																				for(int index$sample26$299 = 0; index$sample26$299 < weightings.length; index$sample26$299 += 1) {
																					int distributionTempVariable$var23$301 = index$sample26$299;
																					double cv$probabilitySample26Value300 = (cv$probabilitySample26Value274 * distribution$sample26[((index$i$298 - 0) / 1)][index$sample26$299]);
																					int traceTempVariable$var39$302_1 = distributionTempVariable$var23$301;
																					if(((index$i$298 + 1) == (j + 1))) {
																						{
																							{
																								double cv$temp$64$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$264_1) + traceTempVariable$var31$276_1) + traceTempVariable$var35$6_1) / traceTempVariable$var39$302_1);
																									cv$temp$64$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample26Value300) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$64$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value300) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$64$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value300) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$64$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value300) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$64$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value300) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$64$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value300);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
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
								}
							}
						}
						int traceTempVariable$var39$7_1 = cv$currentValue;
						for(int j = 0; j < size; j += 1) {
							if(((i + 1) == (j + 1))) {
								if(!guard$sample26bernoulli44[((j - 0) / 1)]) {
									guard$sample26bernoulli44[((j - 0) / 1)] = true;
									{
										double cv$accumulatedConsumerProbabilities = Double.NEGATIVE_INFINITY;
										double cv$consumerDistributionProbabilityAccumulator = 1.0;
										{
											if(fixedFlag$sample12) {
												if(fixedFlag$sample18) {
													if((0 == j)) {
														if((0 == (j + 1))) {
															{
																{
																	double cv$temp$65$var40;
																	{
																		double var40 = ((((1.0 * v1) + v2[j]) + v2[(j + 1)]) / traceTempVariable$var39$7_1);
																		cv$temp$65$var40 = var40;
																	}
																	if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$65$var40)) < cv$accumulatedConsumerProbabilities))
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$65$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																	else {
																		if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																			cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$65$var40));
																		else
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$65$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$65$var40)));
																	}
																	cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																}
															}
														}
													}
												} else {
													if(true) {
														for(int index$sample18$309 = 0; index$sample18$309 < weightings.length; index$sample18$309 += 1) {
															int distributionTempVariable$var15$311 = index$sample18$309;
															double cv$probabilitySample18Value310 = (1.0 * distribution$sample18[index$sample18$309]);
															int traceTempVariable$var31$312_1 = distributionTempVariable$var15$311;
															if((0 == j)) {
																int traceTempVariable$var35$319_1 = distributionTempVariable$var15$311;
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$66$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$312_1) + traceTempVariable$var35$319_1) / traceTempVariable$var39$7_1);
																				cv$temp$66$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$66$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$66$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$66$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$66$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value310) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$66$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value310);
																		}
																	}
																}
																if(!true) {
																	for(int index$sample18$320 = 0; index$sample18$320 < weightings.length; index$sample18$320 += 1) {
																		int distributionTempVariable$var15$322 = index$sample18$320;
																		double cv$probabilitySample18Value321 = (cv$probabilitySample18Value310 * distribution$sample18[index$sample18$320]);
																		int traceTempVariable$var35$323_1 = distributionTempVariable$var15$322;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$67$var40;
																					{
																						double var40 = ((((1.0 * v1) + traceTempVariable$var31$312_1) + traceTempVariable$var35$323_1) / traceTempVariable$var39$7_1);
																						cv$temp$67$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value321) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$67$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value321) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$67$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value321) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$67$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value321) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$67$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value321) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$67$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value321);
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$304 = 0; index$sample12$304 < weightings.length; index$sample12$304 += 1) {
														int distributionTempVariable$v1$306 = index$sample12$304;
														double cv$probabilitySample12Value305 = (1.0 * distribution$sample12[index$sample12$304]);
														int traceTempVariable$v1$307_1 = distributionTempVariable$v1$306;
														if(fixedFlag$sample18) {
															if((0 == j)) {
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$68$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$307_1) + v2[j]) + v2[(j + 1)]) / traceTempVariable$var39$7_1);
																				cv$temp$68$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample12Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$68$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$68$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$68$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$68$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value305) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$68$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value305);
																		}
																	}
																}
															}
														} else {
															if(true) {
																for(int index$sample18$314 = 0; index$sample18$314 < weightings.length; index$sample18$314 += 1) {
																	int distributionTempVariable$var15$316 = index$sample18$314;
																	double cv$probabilitySample18Value315 = (cv$probabilitySample12Value305 * distribution$sample18[index$sample18$314]);
																	int traceTempVariable$var31$317_1 = distributionTempVariable$var15$316;
																	if((0 == j)) {
																		int traceTempVariable$var35$325_1 = distributionTempVariable$var15$316;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$69$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$307_1) + traceTempVariable$var31$317_1) + traceTempVariable$var35$325_1) / traceTempVariable$var39$7_1);
																						cv$temp$69$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value315) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$69$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value315) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$69$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value315) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$69$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value315) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$69$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value315) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$69$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value315);
																				}
																			}
																		}
																		if(!true) {
																			for(int index$sample18$326 = 0; index$sample18$326 < weightings.length; index$sample18$326 += 1) {
																				int distributionTempVariable$var15$328 = index$sample18$326;
																				double cv$probabilitySample18Value327 = (cv$probabilitySample18Value315 * distribution$sample18[index$sample18$326]);
																				int traceTempVariable$var35$329_1 = distributionTempVariable$var15$328;
																				if((0 == (j + 1))) {
																					{
																						{
																							double cv$temp$70$var40;
																							{
																								double var40 = ((((1.0 * traceTempVariable$v1$307_1) + traceTempVariable$var31$317_1) + traceTempVariable$var35$329_1) / traceTempVariable$var39$7_1);
																								cv$temp$70$var40 = var40;
																							}
																							if(((Math.log(cv$probabilitySample18Value327) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$70$var40)) < cv$accumulatedConsumerProbabilities))
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value327) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$70$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																							else {
																								if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																									cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value327) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$70$var40));
																								else
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value327) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$70$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value327) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$70$var40)));
																							}
																							cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value327);
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												int traceTempVariable$var31$335_1 = cv$currentValue;
												if(((index$i$1 + 1) == j)) {
													if(fixedFlag$sample18) {
														if((0 == (j + 1))) {
															{
																{
																	double cv$temp$71$var40;
																	{
																		double var40 = ((((1.0 * v1) + traceTempVariable$var31$335_1) + v2[(j + 1)]) / traceTempVariable$var39$7_1);
																		cv$temp$71$var40 = var40;
																	}
																	if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$71$var40)) < cv$accumulatedConsumerProbabilities))
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$71$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																	else {
																		if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																			cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$71$var40));
																		else
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$71$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$71$var40)));
																	}
																	cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																}
															}
														}
													} else {
														if(true) {
															for(int index$sample18$348 = 0; index$sample18$348 < weightings.length; index$sample18$348 += 1) {
																int distributionTempVariable$var15$350 = index$sample18$348;
																double cv$probabilitySample18Value349 = (1.0 * distribution$sample18[index$sample18$348]);
																int traceTempVariable$var35$351_1 = distributionTempVariable$var15$350;
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$72$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$335_1) + traceTempVariable$var35$351_1) / traceTempVariable$var39$7_1);
																				cv$temp$72$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value349) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$72$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value349) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$72$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value349) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$72$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value349) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$72$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value349) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$72$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value349);
																		}
																	}
																}
															}
														}
													}
												}
												for(int index$i$336 = 0; index$i$336 < size; index$i$336 += 1) {
													if(!(index$i$336 == index$i$1)) {
														for(int index$sample26$337 = 0; index$sample26$337 < weightings.length; index$sample26$337 += 1) {
															int distributionTempVariable$var23$339 = index$sample26$337;
															double cv$probabilitySample26Value338 = (1.0 * distribution$sample26[((index$i$336 - 0) / 1)][index$sample26$337]);
															int traceTempVariable$var31$340_1 = distributionTempVariable$var23$339;
															if(((index$i$336 + 1) == j)) {
																if(fixedFlag$sample18) {
																	if((0 == (j + 1))) {
																		{
																			{
																				double cv$temp$73$var40;
																				{
																					double var40 = ((((1.0 * v1) + traceTempVariable$var31$340_1) + v2[(j + 1)]) / traceTempVariable$var39$7_1);
																					cv$temp$73$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value338) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$73$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value338) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$73$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value338) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$73$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value338) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$73$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value338) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$73$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value338);
																			}
																		}
																	}
																} else {
																	if(true) {
																		for(int index$sample18$353 = 0; index$sample18$353 < weightings.length; index$sample18$353 += 1) {
																			int distributionTempVariable$var15$355 = index$sample18$353;
																			double cv$probabilitySample18Value354 = (cv$probabilitySample26Value338 * distribution$sample18[index$sample18$353]);
																			int traceTempVariable$var35$356_1 = distributionTempVariable$var15$355;
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$74$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$340_1) + traceTempVariable$var35$356_1) / traceTempVariable$var39$7_1);
																							cv$temp$74$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample18Value354) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$74$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value354) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$74$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value354) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$74$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value354) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$74$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value354) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$74$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value354);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$331 = 0; index$sample12$331 < weightings.length; index$sample12$331 += 1) {
														int distributionTempVariable$v1$333 = index$sample12$331;
														double cv$probabilitySample12Value332 = (1.0 * distribution$sample12[index$sample12$331]);
														int traceTempVariable$v1$334_1 = distributionTempVariable$v1$333;
														int traceTempVariable$var31$341_1 = cv$currentValue;
														if(((index$i$1 + 1) == j)) {
															if(fixedFlag$sample18) {
																if((0 == (j + 1))) {
																	{
																		{
																			double cv$temp$75$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$334_1) + traceTempVariable$var31$341_1) + v2[(j + 1)]) / traceTempVariable$var39$7_1);
																				cv$temp$75$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample12Value332) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$75$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value332) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$75$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value332) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$75$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value332) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$75$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value332) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$75$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value332);
																		}
																	}
																}
															} else {
																if(true) {
																	for(int index$sample18$358 = 0; index$sample18$358 < weightings.length; index$sample18$358 += 1) {
																		int distributionTempVariable$var15$360 = index$sample18$358;
																		double cv$probabilitySample18Value359 = (cv$probabilitySample12Value332 * distribution$sample18[index$sample18$358]);
																		int traceTempVariable$var35$361_1 = distributionTempVariable$var15$360;
																		if((0 == (j + 1))) {
																			{
																				{
																					double cv$temp$76$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$334_1) + traceTempVariable$var31$341_1) + traceTempVariable$var35$361_1) / traceTempVariable$var39$7_1);
																						cv$temp$76$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value359) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$76$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value359) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$76$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value359) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$76$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value359) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$76$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value359) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$76$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value359);
																				}
																			}
																		}
																	}
																}
															}
														}
														for(int index$i$342 = 0; index$i$342 < size; index$i$342 += 1) {
															if(!(index$i$342 == index$i$1)) {
																for(int index$sample26$343 = 0; index$sample26$343 < weightings.length; index$sample26$343 += 1) {
																	int distributionTempVariable$var23$345 = index$sample26$343;
																	double cv$probabilitySample26Value344 = (cv$probabilitySample12Value332 * distribution$sample26[((index$i$342 - 0) / 1)][index$sample26$343]);
																	int traceTempVariable$var31$346_1 = distributionTempVariable$var23$345;
																	if(((index$i$342 + 1) == j)) {
																		if(fixedFlag$sample18) {
																			if((0 == (j + 1))) {
																				{
																					{
																						double cv$temp$77$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$334_1) + traceTempVariable$var31$346_1) + v2[(j + 1)]) / traceTempVariable$var39$7_1);
																							cv$temp$77$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value344) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$77$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value344) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$77$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value344) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$77$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value344) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$77$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value344) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$77$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value344);
																					}
																				}
																			}
																		} else {
																			if(true) {
																				for(int index$sample18$363 = 0; index$sample18$363 < weightings.length; index$sample18$363 += 1) {
																					int distributionTempVariable$var15$365 = index$sample18$363;
																					double cv$probabilitySample18Value364 = (cv$probabilitySample26Value344 * distribution$sample18[index$sample18$363]);
																					int traceTempVariable$var35$366_1 = distributionTempVariable$var15$365;
																					if((0 == (j + 1))) {
																						{
																							{
																								double cv$temp$78$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$334_1) + traceTempVariable$var31$346_1) + traceTempVariable$var35$366_1) / traceTempVariable$var39$7_1);
																									cv$temp$78$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample18Value364) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$78$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value364) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$78$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value364) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$78$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value364) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$78$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value364) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$78$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value364);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												if(fixedFlag$sample18) {
													if((0 == j)) {
														int traceTempVariable$var35$382_1 = cv$currentValue;
														if(((index$i$1 + 1) == (j + 1))) {
															{
																{
																	double cv$temp$79$var40;
																	{
																		double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$382_1) / traceTempVariable$var39$7_1);
																		cv$temp$79$var40 = var40;
																	}
																	if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$79$var40)) < cv$accumulatedConsumerProbabilities))
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$79$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																	else {
																		if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																			cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$79$var40));
																		else
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$79$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$79$var40)));
																	}
																	cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
																}
															}
														}
														for(int index$i$383 = 0; index$i$383 < size; index$i$383 += 1) {
															if(!(index$i$383 == index$i$1)) {
																for(int index$sample26$384 = 0; index$sample26$384 < weightings.length; index$sample26$384 += 1) {
																	int distributionTempVariable$var23$386 = index$sample26$384;
																	double cv$probabilitySample26Value385 = (1.0 * distribution$sample26[((index$i$383 - 0) / 1)][index$sample26$384]);
																	int traceTempVariable$var35$387_1 = distributionTempVariable$var23$386;
																	if(((index$i$383 + 1) == (j + 1))) {
																		{
																			{
																				double cv$temp$80$var40;
																				{
																					double var40 = ((((1.0 * v1) + v2[j]) + traceTempVariable$var35$387_1) / traceTempVariable$var39$7_1);
																					cv$temp$80$var40 = var40;
																				}
																				if(((Math.log(cv$probabilitySample26Value385) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$80$var40)) < cv$accumulatedConsumerProbabilities))
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value385) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$80$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																				else {
																					if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																						cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value385) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$80$var40));
																					else
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value385) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$80$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value385) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$80$var40)));
																				}
																				cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value385);
																			}
																		}
																	}
																}
															}
														}
													}
												} else {
													if(true) {
														for(int index$sample18$373 = 0; index$sample18$373 < weightings.length; index$sample18$373 += 1) {
															int distributionTempVariable$var15$375 = index$sample18$373;
															double cv$probabilitySample18Value374 = (1.0 * distribution$sample18[index$sample18$373]);
															int traceTempVariable$var31$376_1 = distributionTempVariable$var15$375;
															if((0 == j)) {
																int traceTempVariable$var35$388_1 = cv$currentValue;
																if(((index$i$1 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$81$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$376_1) + traceTempVariable$var35$388_1) / traceTempVariable$var39$7_1);
																				cv$temp$81$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample18Value374) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$81$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value374) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$81$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value374) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$81$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value374) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$81$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value374) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$81$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value374);
																		}
																	}
																}
																for(int index$i$389 = 0; index$i$389 < size; index$i$389 += 1) {
																	if(!(index$i$389 == index$i$1)) {
																		for(int index$sample26$390 = 0; index$sample26$390 < weightings.length; index$sample26$390 += 1) {
																			int distributionTempVariable$var23$392 = index$sample26$390;
																			double cv$probabilitySample26Value391 = (cv$probabilitySample18Value374 * distribution$sample26[((index$i$389 - 0) / 1)][index$sample26$390]);
																			int traceTempVariable$var35$393_1 = distributionTempVariable$var23$392;
																			if(((index$i$389 + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$82$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$376_1) + traceTempVariable$var35$393_1) / traceTempVariable$var39$7_1);
																							cv$temp$82$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value391) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$82$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value391) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$82$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value391) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$82$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value391) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$82$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value391) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$82$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value391);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$368 = 0; index$sample12$368 < weightings.length; index$sample12$368 += 1) {
														int distributionTempVariable$v1$370 = index$sample12$368;
														double cv$probabilitySample12Value369 = (1.0 * distribution$sample12[index$sample12$368]);
														int traceTempVariable$v1$371_1 = distributionTempVariable$v1$370;
														if(fixedFlag$sample18) {
															if((0 == j)) {
																int traceTempVariable$var35$394_1 = cv$currentValue;
																if(((index$i$1 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$83$var40;
																			{
																				double var40 = ((((1.0 * traceTempVariable$v1$371_1) + v2[j]) + traceTempVariable$var35$394_1) / traceTempVariable$var39$7_1);
																				cv$temp$83$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample12Value369) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$83$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value369) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$83$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value369) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$83$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value369) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$83$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value369) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$83$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value369);
																		}
																	}
																}
																for(int index$i$395 = 0; index$i$395 < size; index$i$395 += 1) {
																	if(!(index$i$395 == index$i$1)) {
																		for(int index$sample26$396 = 0; index$sample26$396 < weightings.length; index$sample26$396 += 1) {
																			int distributionTempVariable$var23$398 = index$sample26$396;
																			double cv$probabilitySample26Value397 = (cv$probabilitySample12Value369 * distribution$sample26[((index$i$395 - 0) / 1)][index$sample26$396]);
																			int traceTempVariable$var35$399_1 = distributionTempVariable$var23$398;
																			if(((index$i$395 + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$84$var40;
																						{
																							double var40 = ((((1.0 * traceTempVariable$v1$371_1) + v2[j]) + traceTempVariable$var35$399_1) / traceTempVariable$var39$7_1);
																							cv$temp$84$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value397) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$84$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value397) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$84$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value397) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$84$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value397) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$84$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value397) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$84$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value397);
																					}
																				}
																			}
																		}
																	}
																}
															}
														} else {
															if(true) {
																for(int index$sample18$378 = 0; index$sample18$378 < weightings.length; index$sample18$378 += 1) {
																	int distributionTempVariable$var15$380 = index$sample18$378;
																	double cv$probabilitySample18Value379 = (cv$probabilitySample12Value369 * distribution$sample18[index$sample18$378]);
																	int traceTempVariable$var31$381_1 = distributionTempVariable$var15$380;
																	if((0 == j)) {
																		int traceTempVariable$var35$400_1 = cv$currentValue;
																		if(((index$i$1 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$85$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$371_1) + traceTempVariable$var31$381_1) + traceTempVariable$var35$400_1) / traceTempVariable$var39$7_1);
																						cv$temp$85$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample18Value379) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$85$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample18Value379) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$85$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample18Value379) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$85$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample18Value379) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$85$var40)))) + 1)) + (Math.log(cv$probabilitySample18Value379) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$85$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample18Value379);
																				}
																			}
																		}
																		for(int index$i$401 = 0; index$i$401 < size; index$i$401 += 1) {
																			if(!(index$i$401 == index$i$1)) {
																				for(int index$sample26$402 = 0; index$sample26$402 < weightings.length; index$sample26$402 += 1) {
																					int distributionTempVariable$var23$404 = index$sample26$402;
																					double cv$probabilitySample26Value403 = (cv$probabilitySample18Value379 * distribution$sample26[((index$i$401 - 0) / 1)][index$sample26$402]);
																					int traceTempVariable$var35$405_1 = distributionTempVariable$var23$404;
																					if(((index$i$401 + 1) == (j + 1))) {
																						{
																							{
																								double cv$temp$86$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$371_1) + traceTempVariable$var31$381_1) + traceTempVariable$var35$405_1) / traceTempVariable$var39$7_1);
																									cv$temp$86$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample26Value403) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$86$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value403) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$86$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value403) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$86$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value403) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$86$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value403) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$86$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value403);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
											if(fixedFlag$sample12) {
												int traceTempVariable$var31$411_1 = cv$currentValue;
												if(((index$i$1 + 1) == j)) {
													int traceTempVariable$var35$423_1 = cv$currentValue;
													if(((index$i$1 + 1) == (j + 1))) {
														{
															{
																double cv$temp$87$var40;
																{
																	double var40 = ((((1.0 * v1) + traceTempVariable$var31$411_1) + traceTempVariable$var35$423_1) / traceTempVariable$var39$7_1);
																	cv$temp$87$var40 = var40;
																}
																if(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$87$var40)) < cv$accumulatedConsumerProbabilities))
																	cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$87$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																else {
																	if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																		cv$accumulatedConsumerProbabilities = (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$87$var40));
																	else
																		cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$87$var40)))) + 1)) + (Math.log(1.0) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$87$var40)));
																}
																cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - 1.0);
															}
														}
													}
													for(int index$i$424 = 0; index$i$424 < size; index$i$424 += 1) {
														if(!(index$i$424 == index$i$1)) {
															for(int index$sample26$425 = 0; index$sample26$425 < weightings.length; index$sample26$425 += 1) {
																int distributionTempVariable$var23$427 = index$sample26$425;
																double cv$probabilitySample26Value426 = (1.0 * distribution$sample26[((index$i$424 - 0) / 1)][index$sample26$425]);
																int traceTempVariable$var35$428_1 = distributionTempVariable$var23$427;
																if(((index$i$424 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$88$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$411_1) + traceTempVariable$var35$428_1) / traceTempVariable$var39$7_1);
																				cv$temp$88$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value426) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$88$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value426) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$88$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value426) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$88$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value426) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$88$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value426) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$88$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value426);
																		}
																	}
																}
															}
														}
													}
												}
												for(int index$i$412 = 0; index$i$412 < size; index$i$412 += 1) {
													if(!(index$i$412 == index$i$1)) {
														for(int index$sample26$413 = 0; index$sample26$413 < weightings.length; index$sample26$413 += 1) {
															int distributionTempVariable$var23$415 = index$sample26$413;
															double cv$probabilitySample26Value414 = (1.0 * distribution$sample26[((index$i$412 - 0) / 1)][index$sample26$413]);
															int traceTempVariable$var31$416_1 = distributionTempVariable$var23$415;
															if(((index$i$412 + 1) == j)) {
																int traceTempVariable$var35$429_1 = cv$currentValue;
																if(((index$i$1 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$89$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$416_1) + traceTempVariable$var35$429_1) / traceTempVariable$var39$7_1);
																				cv$temp$89$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value414) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$89$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value414) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$89$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value414) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$89$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value414) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$89$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value414) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$89$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value414);
																		}
																	}
																}
																int traceTempVariable$var35$430_1 = distributionTempVariable$var23$415;
																if(((index$i$412 + 1) == (j + 1))) {
																	{
																		{
																			double cv$temp$90$var40;
																			{
																				double var40 = ((((1.0 * v1) + traceTempVariable$var31$416_1) + traceTempVariable$var35$430_1) / traceTempVariable$var39$7_1);
																				cv$temp$90$var40 = var40;
																			}
																			if(((Math.log(cv$probabilitySample26Value414) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$90$var40)) < cv$accumulatedConsumerProbabilities))
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value414) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$90$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																			else {
																				if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																					cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value414) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$90$var40));
																				else
																					cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value414) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$90$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value414) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$90$var40)));
																			}
																			cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value414);
																		}
																	}
																}
																for(int index$i$431 = 0; index$i$431 < size; index$i$431 += 1) {
																	if((!(index$i$431 == index$i$1) && !(index$i$431 == index$i$412))) {
																		for(int index$sample26$432 = 0; index$sample26$432 < weightings.length; index$sample26$432 += 1) {
																			int distributionTempVariable$var23$434 = index$sample26$432;
																			double cv$probabilitySample26Value433 = (cv$probabilitySample26Value414 * distribution$sample26[((index$i$431 - 0) / 1)][index$sample26$432]);
																			int traceTempVariable$var35$435_1 = distributionTempVariable$var23$434;
																			if(((index$i$431 + 1) == (j + 1))) {
																				{
																					{
																						double cv$temp$91$var40;
																						{
																							double var40 = ((((1.0 * v1) + traceTempVariable$var31$416_1) + traceTempVariable$var35$435_1) / traceTempVariable$var39$7_1);
																							cv$temp$91$var40 = var40;
																						}
																						if(((Math.log(cv$probabilitySample26Value433) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$91$var40)) < cv$accumulatedConsumerProbabilities))
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value433) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$91$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																						else {
																							if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																								cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value433) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$91$var40));
																							else
																								cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value433) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$91$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value433) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$91$var40)));
																						}
																						cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value433);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if(true) {
													for(int index$sample12$407 = 0; index$sample12$407 < weightings.length; index$sample12$407 += 1) {
														int distributionTempVariable$v1$409 = index$sample12$407;
														double cv$probabilitySample12Value408 = (1.0 * distribution$sample12[index$sample12$407]);
														int traceTempVariable$v1$410_1 = distributionTempVariable$v1$409;
														int traceTempVariable$var31$417_1 = cv$currentValue;
														if(((index$i$1 + 1) == j)) {
															int traceTempVariable$var35$436_1 = cv$currentValue;
															if(((index$i$1 + 1) == (j + 1))) {
																{
																	{
																		double cv$temp$92$var40;
																		{
																			double var40 = ((((1.0 * traceTempVariable$v1$410_1) + traceTempVariable$var31$417_1) + traceTempVariable$var35$436_1) / traceTempVariable$var39$7_1);
																			cv$temp$92$var40 = var40;
																		}
																		if(((Math.log(cv$probabilitySample12Value408) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$92$var40)) < cv$accumulatedConsumerProbabilities))
																			cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample12Value408) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$92$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																		else {
																			if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																				cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample12Value408) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$92$var40));
																			else
																				cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample12Value408) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$92$var40)))) + 1)) + (Math.log(cv$probabilitySample12Value408) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$92$var40)));
																		}
																		cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample12Value408);
																	}
																}
															}
															for(int index$i$437 = 0; index$i$437 < size; index$i$437 += 1) {
																if(!(index$i$437 == index$i$1)) {
																	for(int index$sample26$438 = 0; index$sample26$438 < weightings.length; index$sample26$438 += 1) {
																		int distributionTempVariable$var23$440 = index$sample26$438;
																		double cv$probabilitySample26Value439 = (cv$probabilitySample12Value408 * distribution$sample26[((index$i$437 - 0) / 1)][index$sample26$438]);
																		int traceTempVariable$var35$441_1 = distributionTempVariable$var23$440;
																		if(((index$i$437 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$93$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$410_1) + traceTempVariable$var31$417_1) + traceTempVariable$var35$441_1) / traceTempVariable$var39$7_1);
																						cv$temp$93$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value439) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$93$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value439) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$93$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value439) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$93$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value439) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$93$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value439) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$93$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value439);
																				}
																			}
																		}
																	}
																}
															}
														}
														for(int index$i$418 = 0; index$i$418 < size; index$i$418 += 1) {
															if(!(index$i$418 == index$i$1)) {
																for(int index$sample26$419 = 0; index$sample26$419 < weightings.length; index$sample26$419 += 1) {
																	int distributionTempVariable$var23$421 = index$sample26$419;
																	double cv$probabilitySample26Value420 = (cv$probabilitySample12Value408 * distribution$sample26[((index$i$418 - 0) / 1)][index$sample26$419]);
																	int traceTempVariable$var31$422_1 = distributionTempVariable$var23$421;
																	if(((index$i$418 + 1) == j)) {
																		int traceTempVariable$var35$442_1 = cv$currentValue;
																		if(((index$i$1 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$94$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$410_1) + traceTempVariable$var31$422_1) + traceTempVariable$var35$442_1) / traceTempVariable$var39$7_1);
																						cv$temp$94$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value420) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$94$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value420) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$94$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value420) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$94$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value420) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$94$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value420) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$94$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value420);
																				}
																			}
																		}
																		int traceTempVariable$var35$443_1 = distributionTempVariable$var23$421;
																		if(((index$i$418 + 1) == (j + 1))) {
																			{
																				{
																					double cv$temp$95$var40;
																					{
																						double var40 = ((((1.0 * traceTempVariable$v1$410_1) + traceTempVariable$var31$422_1) + traceTempVariable$var35$443_1) / traceTempVariable$var39$7_1);
																						cv$temp$95$var40 = var40;
																					}
																					if(((Math.log(cv$probabilitySample26Value420) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$95$var40)) < cv$accumulatedConsumerProbabilities))
																						cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value420) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$95$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																					else {
																						if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																							cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value420) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$95$var40));
																						else
																							cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value420) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$95$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value420) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$95$var40)));
																					}
																					cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value420);
																				}
																			}
																		}
																		for(int index$i$444 = 0; index$i$444 < size; index$i$444 += 1) {
																			if((!(index$i$444 == index$i$1) && !(index$i$444 == index$i$418))) {
																				for(int index$sample26$445 = 0; index$sample26$445 < weightings.length; index$sample26$445 += 1) {
																					int distributionTempVariable$var23$447 = index$sample26$445;
																					double cv$probabilitySample26Value446 = (cv$probabilitySample26Value420 * distribution$sample26[((index$i$444 - 0) / 1)][index$sample26$445]);
																					int traceTempVariable$var35$448_1 = distributionTempVariable$var23$447;
																					if(((index$i$444 + 1) == (j + 1))) {
																						{
																							{
																								double cv$temp$96$var40;
																								{
																									double var40 = ((((1.0 * traceTempVariable$v1$410_1) + traceTempVariable$var31$422_1) + traceTempVariable$var35$448_1) / traceTempVariable$var39$7_1);
																									cv$temp$96$var40 = var40;
																								}
																								if(((Math.log(cv$probabilitySample26Value446) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$96$var40)) < cv$accumulatedConsumerProbabilities))
																									cv$accumulatedConsumerProbabilities = (Math.log((Math.exp(((Math.log(cv$probabilitySample26Value446) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$96$var40)) - cv$accumulatedConsumerProbabilities)) + 1)) + cv$accumulatedConsumerProbabilities);
																								else {
																									if((cv$accumulatedConsumerProbabilities == Double.NEGATIVE_INFINITY))
																										cv$accumulatedConsumerProbabilities = (Math.log(cv$probabilitySample26Value446) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$96$var40));
																									else
																										cv$accumulatedConsumerProbabilities = (Math.log((Math.exp((cv$accumulatedConsumerProbabilities - (Math.log(cv$probabilitySample26Value446) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$96$var40)))) + 1)) + (Math.log(cv$probabilitySample26Value446) + DistributionSampling.logProbabilityBernoulli(v[j], cv$temp$96$var40)));
																								}
																								cv$consumerDistributionProbabilityAccumulator = (cv$consumerDistributionProbabilityAccumulator - cv$probabilitySample26Value446);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
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
								}
							}
						}
					}
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
			cv$stateProbabilityLocal[cv$valuePos] = ((cv$stateProbabilityValue - Math.log(cv$reachedDistributionSourceRV)) + cv$accumulatedDistributionProbabilities);
		}
		double[] cv$localProbability = distribution$sample26[((i - 0) / 1)];
		double cv$logSum = 0.0;
		{
			double cv$lseMax = cv$stateProbabilityLocal[0];
			for(int cv$lseIndex = 1; cv$lseIndex < cv$stateProbabilityLocal.length; cv$lseIndex += 1) {
				double cv$lseElementValue = cv$stateProbabilityLocal[cv$lseIndex];
				if((cv$lseMax < cv$lseElementValue))
					cv$lseMax = cv$lseElementValue;
			}
			if((cv$lseMax == Double.NEGATIVE_INFINITY))
				cv$logSum = Double.NEGATIVE_INFINITY;
			else {
				double cv$lseSum = 0.0;
				for(int cv$lseIndex = 0; cv$lseIndex < cv$stateProbabilityLocal.length; cv$lseIndex += 1)
					cv$lseSum = (cv$lseSum + Math.exp((cv$stateProbabilityLocal[cv$lseIndex] - cv$lseMax)));
				cv$logSum = (cv$logSum + (Math.log(cv$lseSum) + cv$lseMax));
			}
		}
		if((cv$logSum == Double.NEGATIVE_INFINITY)) {
			for(int cv$indexName = 0; cv$indexName < cv$stateProbabilityLocal.length; cv$indexName += 1)
				cv$localProbability[cv$indexName] = (1.0 / cv$stateProbabilityLocal.length);
		} else {
			for(int cv$indexName = 0; cv$indexName < cv$stateProbabilityLocal.length; cv$indexName += 1)
				cv$localProbability[cv$indexName] = Math.exp((cv$stateProbabilityLocal[cv$indexName] - cv$logSum));
		}
	}

	@Override
	public final void allocateScratch() {
		{
			cv$var9$stateProbabilityGlobal = new double[weightings.length];
		}
		{
			cv$var15$stateProbabilityGlobal = new double[weightings.length];
		}
		{
			int cv$max_j = 0;
			cv$max_j = Math.max(cv$max_j, ((length$value - 0) / 1));
			guard$sample18bernoulli44$global = new boolean[cv$max_j];
		}
		{
			cv$var23$stateProbabilityGlobal = new double[weightings.length];
		}
		{
			int cv$max_j = 0;
			cv$max_j = Math.max(cv$max_j, ((length$value - 0) / 1));
			guard$sample26bernoulli44$global = new boolean[cv$max_j];
		}
	}

	@Override
	public final void allocator() {
		if(!setFlag$v2) {
			{
				v2 = new int[(length$value + 1)];
			}
		}
		if(!setFlag$v) {
			{
				v = new boolean[length$value];
			}
		}
		{
			distribution$sample18 = new double[weightings.length];
		}
		{
			distribution$sample26 = new double[((((length$value - 1) - 0) / 1) + 1)][];
			for(int i = 0; i < length$value; i += 1)
				distribution$sample26[((i - 0) / 1)] = new double[weightings.length];
		}
		{
			distribution$sample12 = new double[weightings.length];
		}
		{
			logProbability$var22 = new double[((((length$value - 1) - 0) / 1) + 1)];
		}
		{
			logProbability$sample26 = new double[((((length$value - 1) - 0) / 1) + 1)];
		}
		{
			logProbability$var41 = new double[((((length$value - 1) - 0) / 1) + 1)];
		}
		{
			logProbability$sample45 = new double[((((length$value - 1) - 0) / 1) + 1)];
		}
		allocateScratch();
	}

	@Override
	public final void forwardGeneration() {
		if(!fixedFlag$sample12)
			v1 = DistributionSampling.sampleCategorical(RNG$, weightings);
		if(!fixedFlag$sample18)
			v2[0] = DistributionSampling.sampleCategorical(RNG$, weightings);
		parallelFor(RNG$, 0, size, 1,
			(int forStart$i, int forEnd$i, int threadID$i, org.sandwood.random.internal.Rng RNG$1) -> { 
				for(int i = forStart$i; i < forEnd$i; i += 1) {
						if(!fixedFlag$sample26)
							v2[(i + 1)] = DistributionSampling.sampleCategorical(RNG$1, weightings);
					}
			}
		);
		parallelFor(RNG$, 0, size, 1,
			(int forStart$j, int forEnd$j, int threadID$j, org.sandwood.random.internal.Rng RNG$1) -> { 
				for(int j = forStart$j; j < forEnd$j; j += 1) {
						if(!fixedFlag$sample45)
							v[j] = DistributionSampling.sampleBernoulli(RNG$1, ((((1.0 * v1) + v2[j]) + v2[(j + 1)]) / v2[(j + 1)]));
					}
			}
		);
	}

	@Override
	public final void forwardGenerationDistributionsNoOutputs() {
		double[] cv$distribution$sample12 = distribution$sample12;
		for(int index$var8 = 0; index$var8 < weightings.length; index$var8 += 1) {
			double cv$value = DistributionSampling.probabilityCategorical(index$var8, weightings);
			if(!fixedFlag$sample12)
				cv$distribution$sample12[index$var8] = cv$value;
		}
		double[] cv$distribution$sample18 = distribution$sample18;
		for(int index$var14 = 0; index$var14 < weightings.length; index$var14 += 1) {
			double cv$value = DistributionSampling.probabilityCategorical(index$var14, weightings);
			if(!fixedFlag$sample18)
				cv$distribution$sample18[index$var14] = cv$value;
		}
		parallelFor(RNG$, 0, size, 1,
			(int forStart$i, int forEnd$i, int threadID$i, org.sandwood.random.internal.Rng RNG$1) -> { 
				for(int i = forStart$i; i < forEnd$i; i += 1) {
						double[] cv$distribution$sample26 = distribution$sample26[((i - 0) / 1)];
						for(int index$var22 = 0; index$var22 < weightings.length; index$var22 += 1) {
							double cv$value = DistributionSampling.probabilityCategorical(index$var22, weightings);
							if(!fixedFlag$sample26)
								cv$distribution$sample26[index$var22] = cv$value;
						}
					}
			}
		);
	}

	@Override
	public final void forwardGenerationValuesNoOutputs() {
		if(!fixedFlag$sample12)
			v1 = DistributionSampling.sampleCategorical(RNG$, weightings);
		if(!fixedFlag$sample18)
			v2[0] = DistributionSampling.sampleCategorical(RNG$, weightings);
		parallelFor(RNG$, 0, size, 1,
			(int forStart$i, int forEnd$i, int threadID$i, org.sandwood.random.internal.Rng RNG$1) -> { 
				for(int i = forStart$i; i < forEnd$i; i += 1) {
						if(!fixedFlag$sample26)
							v2[(i + 1)] = DistributionSampling.sampleCategorical(RNG$1, weightings);
					}
			}
		);
	}

	@Override
	public final void gibbsRound() {
		if(system$gibbsForward) {
			if(!fixedFlag$sample12)
				sample12();
			if(!fixedFlag$sample18)
				sample18();
			for(int i = 0; i < size; i += 1) {
				if(!fixedFlag$sample26)
					sample26(i);
			}
		} else {
			for(int i = (size - ((((size - 1) - 0) % 1) + 1)); i >= ((0 - 1) + 1); i -= 1) {
				if(!fixedFlag$sample26)
					sample26(i);
			}
			if(!fixedFlag$sample18)
				sample18();
			if(!fixedFlag$sample12)
				sample12();
		}
		system$gibbsForward = !system$gibbsForward;
	}

	@Override
	public final void initializeConstants() {
		size = length$value;
	}

	private final void initializeLogProbabilityFields() {
		logProbability$$model = 0.0;
		logProbability$$evidence = 0.0;
		logProbability$var8 = 0.0;
		if(!fixedProbFlag$sample12)
			logProbability$v1 = 0.0;
		logProbability$var14 = 0.0;
		logProbability$v2 = 0.0;
		if(!fixedProbFlag$sample18)
			logProbability$var15 = 0.0;
		for(int i = 0; i < size; i += 1)
			logProbability$var22[((i - 0) / 1)] = 0.0;
		if(!fixedProbFlag$sample26) {
			for(int i = 0; i < size; i += 1)
				logProbability$sample26[((i - 0) / 1)] = 0.0;
		}
		for(int j = 0; j < size; j += 1)
			logProbability$var41[((j - 0) / 1)] = 0.0;
		logProbability$v = 0.0;
		if(!fixedProbFlag$sample45) {
			for(int j = 0; j < size; j += 1)
				logProbability$sample45[((j - 0) / 1)] = 0.0;
		}
	}

	@Override
	public final void logEvidenceGeneration() {
		forwardGenerationValuesNoOutputs();
		logEvidenceProbabilities();
	}

	private final void logEvidenceProbabilities() {
		initializeLogProbabilityFields();
		logProbabilityValue$sample45();
	}

	@Override
	public final void logModelProbabilitiesDist() {
		initializeLogProbabilityFields();
		logProbabilityDistribution$sample12();
		logProbabilityDistribution$sample18();
		logProbabilityDistribution$sample26();
		logProbabilityDistribution$sample45();
	}

	@Override
	public final void logModelProbabilitiesVal() {
		initializeLogProbabilityFields();
		logProbabilityValue$sample12();
		logProbabilityValue$sample18();
		logProbabilityValue$sample26();
		logProbabilityValue$sample45();
	}

	@Override
	public final void logProbabilityGeneration() {
		if(!fixedFlag$sample12)
			v1 = DistributionSampling.sampleCategorical(RNG$, weightings);
		if(!fixedFlag$sample18)
			v2[0] = DistributionSampling.sampleCategorical(RNG$, weightings);
		parallelFor(RNG$, 0, size, 1,
			(int forStart$i, int forEnd$i, int threadID$i, org.sandwood.random.internal.Rng RNG$1) -> { 
				for(int i = forStart$i; i < forEnd$i; i += 1) {
						if(!fixedFlag$sample26)
							v2[(i + 1)] = DistributionSampling.sampleCategorical(RNG$1, weightings);
					}
			}
		);
		logModelProbabilitiesVal();
	}

	@Override
	public final void propogateObservedValues() {
		boolean[] cv$source1 = value;
		boolean[] cv$target1 = v;
		int cv$length1 = cv$target1.length;
		for(int cv$index1 = 0; cv$index1 < cv$length1; cv$index1 += 1)
			cv$target1[cv$index1] = cv$source1[cv$index1];
	}

	@Override
	public final void setIntermediates() {}

	@Override
	public String modelCode() {
		return "/*\n * Sandwood\n *\n * Copyright (c) 2019-2023, Oracle and/or its affiliates\n * \n * Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl/\n */\n\npackage org.sandwood.compiler.tests.parser;\n\nmodel DistributionTest4(double[] weightings, boolean[] value) {\n    int size = value.length;\n    \n    int v1 = categorical(weightings).sampleDistribution();\n    \n    int[] v2 = new int[size + 1];\n    v2[0] = categorical(weightings).sampleDistribution();\n    for(int i:[0..size))\n        v2[i + 1] = categorical(weightings).sampleDistribution();\n        \n    boolean[] v = new boolean[size];\n    for(int j:[0..size))\n        v[j] = bernoulli(((1.0*v1) + v2[j] + v2[j+1])/v2[j+1]).sample();\n        \n    v.observe(value);\n}\n";
	}
}