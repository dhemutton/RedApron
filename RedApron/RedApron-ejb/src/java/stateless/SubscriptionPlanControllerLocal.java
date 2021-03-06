/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import entity.Recipe;
import entity.SubscriptionPlan;
import exceptions.SubscriptionPlanNotFoundException;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author matthealoo
 */
@Local
public interface SubscriptionPlanControllerLocal {

    public SubscriptionPlan createSubscriptionPlan(SubscriptionPlan subscriptionPlan);

    public List<SubscriptionPlan> retrieveAllSubscriptionPlans();

    public SubscriptionPlan createSubscriptionPlan2(SubscriptionPlan subscriptionPlan, Long subscriberId, Long categoryId);

    public void updatePlan(SubscriptionPlan planToUpdate, Long categoryIdUpdate, Long subscriberIdUpdate);

    public void deleteSubscriptionPlan(Long subscriptionPlanId) throws SubscriptionPlanNotFoundException;

    public List<SubscriptionPlan> retrieveSubscriptionPlanByDateRange(Date date1, Date date2);

    public List<SubscriptionPlan> retrieveSubscriptionPlanByDate(Date date1);

    public List<SubscriptionPlan> retrieveSubscriptionPlanBySubscriberId(Long subscriberId);

    public List<Recipe> retrieveRecipesBySubscriptionPlanId(Long id);

    public SubscriptionPlan retrieveSubscriptionPlanById(Long subscriptionPlanId) throws SubscriptionPlanNotFoundException;

    public List<SubscriptionPlan> retrieveLatestSubscriptionPlan(int num);
    
}
