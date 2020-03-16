package ua.ek.utils;

import org.openqa.selenium.WebDriver;
import ua.ek.steps.HomeStep;
import ua.ek.steps.base.BaseStep;
import ua.ek.steps.registration.AuthStep;
import ua.ek.steps.registration.RegistrationStep;
import ua.ek.steps.registration.UserProfileStep;
import ua.ek.steps.search.SearchStep;
import ua.ek.steps.tablets.TabletStep;
import ua.ek.steps.tablets.TabletsListStep;
import ua.ek.steps.tablets.TabletsManufacturerStep;
import ua.ek.steps.tablets.TabletsStep;
import ua.ek.steps.tablets.filters.PriceFilterStep;
import ua.ek.steps.tablets.manufacturers.AppleTabletsStep;

public class StepFactory {

    public BaseStep createStep(StepType stepType, WebDriver driver){

        BaseStep baseStep = null;

        switch(stepType){
            case HOME_STEP:
                baseStep = new HomeStep(driver);
                break;
            case AUTH_STEP:
                baseStep = new AuthStep(driver);
                break;
            case REGISTRATION_STEP:
                baseStep = new RegistrationStep(driver);
                break;
            case USER_PROFILE_STEP:
                baseStep = new UserProfileStep(driver);
                break;
            case TABLET_STEP:
                baseStep = new TabletStep(driver);
                break;
            case TABLETS_STEP:
                baseStep = new TabletsStep(driver);
                break;
            case TABLETS_LIST_STEP:
                baseStep = new TabletsListStep(driver);
                break;
            case TABLETS_MANUFACTURER_STEP:
                baseStep = new TabletsManufacturerStep(driver);
                break;
            case APPLE_TABLETS_STEP:
                baseStep = new AppleTabletsStep(driver);
                break;
            case SEARCH_STEP:
                baseStep = new SearchStep(driver);
                break;
            case PRICE_FILTER_STEP:
                baseStep = new PriceFilterStep(driver);
                break;
            default:
                break;
        }

        return baseStep;
    }
}