/*
 * Sandwood
 *
 * Copyright (c) 2019-2023, Oracle and/or its affiliates
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl/
 */

package org.sandwood.compiler.trees.transformationTree.binop;

import org.sandwood.compiler.dataflowGraph.variables.VariableType.Type;
import org.sandwood.compiler.dataflowGraph.variables.scalarVariables.NumberVariable;
import org.sandwood.compiler.trees.outputTree.OutputTree;
import org.sandwood.compiler.trees.outputTree.OutputTreeReturn;
import org.sandwood.compiler.trees.transformationTree.TransTreeReturn;
import org.sandwood.compiler.trees.transformationTree.transformers.Transformer;
import org.sandwood.compiler.trees.transformationTree.util.Bounds;

public class TransMin<A extends NumberVariable<A>> extends TransBinOp<A, A, A> {

    private TransMin(TransTreeReturn<A> left, TransTreeReturn<A> right) {
        super(left, right, true, TransTreeType.MIN);
    }

    @Override
    public OutputTreeReturn<A> toOutputTreeReturnInternal() {
        return OutputTree.min(left.toOutputTreeReturnInternal(), right.toOutputTreeReturnInternal());
    }

    public static <A extends NumberVariable<A>> TransMin<A> min(TransTreeReturn<A> left, TransTreeReturn<A> right) {
        return new TransMin<>(left, right);
    }

    @Override
    public TransMin<A> applyTransformationInternal(Transformer t) {
        return new TransMin<>(t.transform(left), t.transform(right));
    }

    @Override
    public Type<A> getOutputType() {
        return left.getOutputType();
    }

    @Override
    public TransTreeReturn<A> maxValueInternal(Bounds bounds) {
        return new TransMin<>(left.maxValue(bounds), right.maxValue(bounds));
    }

    @Override
    public TransTreeReturn<A> minValueInternal(Bounds bounds) {
        return new TransMin<>(left.minValue(bounds), right.minValue(bounds));
    }

    @Override
    protected String getOp() {
        return "min";
    }
}
