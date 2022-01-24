package com.mygodoc.app.tests.clinic;

import com.mygodoc.app.pages.admin.AdminDashboardPage;
import com.mygodoc.app.pages.clinic.ClinicHomePage;
import com.mygodoc.app.pages.clinic.PatientManagementPage;
import com.mygodoc.app.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.hamcrest.CoreMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Epic("Patient Management Test")
@Feature("Patient Management")
public class PatientMgmtTest extends BaseTest {
    @Autowired
    AdminDashboardPage dashboardPage;

    @Autowired
    ClinicHomePage clinicPage;

    @Autowired
    PatientManagementPage patientMgmtPage;

    @BeforeClass
    public void navigateToPatientManagementPage(){
        clinicPage = dashboardPage.getClinic("TestAutomationPractice1");
        patientMgmtPage = clinicPage.navigateToPatientMgmtDashboard();
    }



    @Test
    public void verifyClinicIsAbleCheckPatientList(){
        System.out.println(patientMgmtPage.getPatientList());
        assertThat(patientMgmtPage.getPatientList().size(), greaterThan(0));
    }

    @Test
    public void verifyClinicIsAbleCheckPatientDetails(){
        patientMgmtPage.selectPatient("test test");
        assertThat(patientMgmtPage.getPatientName(),is(not(emptyString())));
    }

    @Test(priority = 1)
    public void verifyClinicIsAbleAddPatient(){
        patientMgmtPage.addPatient();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
