/*
 * Sandwood
 *
 * Copyright (c) 2019-2024, Oracle and/or its affiliates
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl/
 */

package org.sandwood.compiler.dataflowGraph.tasks.returnTasks.rvConstructor;

import org.sandwood.compiler.dataflowGraph.tasks.DFType;
import org.sandwood.compiler.dataflowGraph.variables.VariableType;
import org.sandwood.compiler.dataflowGraph.variables.arrayVariable.ArrayVariable;
import org.sandwood.compiler.dataflowGraph.variables.randomVariables.Dirichlet;
import org.sandwood.compiler.dataflowGraph.variables.scalarVariables.DoubleVariable;
import org.sandwood.compiler.srcTools.sourceToSource.Location;

public class DirichletTask extends RandomVariableConstructorTask<ArrayVariable<DoubleVariable>, Dirichlet> {
    public DirichletTask(ArrayVariable<DoubleVariable> beta, Location location) {
        super(DFType.DIRICHLET, VariableType.Dirichlet, location, beta.getCurrentInstance());
    }
}
