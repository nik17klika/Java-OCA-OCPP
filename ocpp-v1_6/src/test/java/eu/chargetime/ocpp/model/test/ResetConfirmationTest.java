package eu.chargetime.ocpp.model.test;

import eu.chargetime.ocpp.PropertyConstraintException;
import eu.chargetime.ocpp.model.ResetConfirmation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * ChargeTime.eu - Java-OCA-OCPP
 * <p>
 * MIT License
 * <p>
 * Copyright (C) 2016 Thomas Volden <tv@chargetime.eu>
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class ResetConfirmationTest {
    ResetConfirmation confirmation;

    @Before
    public void setUp() throws Exception {
        confirmation = new ResetConfirmation();
    }

    @Test
    public void setStatus_illegalString_throwsPropertyConstraintException() {
        // Given
        String illegal = "some status";

        try {
            // When
            confirmation.setStatus(illegal);

            Assert.fail("Expected PropertyConstraintException");
        } catch (PropertyConstraintException ex) {
            assertThat(ex.getFieldKey(), equalTo("status"));
            assertThat(ex.getFieldValue(), equalTo(illegal));
        }
    }

    @Test
    public void setStatus_accepted_statusIsSet() throws Exception {
        // Given
        String resetStatus = "Accepted";

        // When
        confirmation.setStatus(resetStatus);

        // Then
        assertThat(confirmation.getStatus(), equalTo(resetStatus));
    }

    @Test
    public void setStatus_rejected_statusIsSet() throws Exception {
        // Given
        String resetStatus = "Rejected";

        // When
        confirmation.setStatus(resetStatus);

        // Then
        assertThat(confirmation.getStatus(), equalTo(resetStatus));
    }

    @Test
    public void validate_returnFalse() {
        // When
        boolean isValid = confirmation.validate();

        // Then
        assertThat(isValid, is(false));
    }

    @Test
    public void validate_statusIsSet_returnTrue() throws Exception {
        // Given
        confirmation.setStatus("Accepted");

        // When
        boolean isValid = confirmation.validate();

        // Then
        assertThat(isValid, is(true));
    }
}