package io.quarkus.workshop.superheroes.hero;

import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

@QuarkusTest
@Provider("rest-heroes")
@PactFolder("pacts")
public class HeroContractVerificationTest {
    @ConfigProperty(name = "quarkus.http.test-port")
    int quarkusPort;


    @BeforeEach
    void beforeEach(PactVerificationContext context) {
        context.setTarget(new HttpTestTarget("localhost", this.quarkusPort));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }
}