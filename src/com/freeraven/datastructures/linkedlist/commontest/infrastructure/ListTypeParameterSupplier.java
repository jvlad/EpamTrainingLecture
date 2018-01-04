package com.freeraven.datastructures.linkedlist.commontest.infrastructure;

import com.freeraven.datastructures.linkedlist.commontest.ListTypesToTest;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zvlad on 7/4/16.
 */
public class ListTypeParameterSupplier extends ParameterSupplier {
    @Retention(RetentionPolicy.RUNTIME)
    @ParametersSuppliedBy(ListTypeParameterSupplier.class)
    public @interface ListTypes {
    }

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature parameterSignature) throws Throwable {
        return ListTypesToTest.LIST_TYPES_TO_TEST
                .stream()
                .map(listType ->
                             PotentialAssignment.forValue(listType.getSimpleName(), listType))
                .collect(Collectors.toList());
    }
}
