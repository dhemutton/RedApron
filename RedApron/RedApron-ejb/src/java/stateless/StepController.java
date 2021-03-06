/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import entity.Recipe;
import entity.Step;
import exceptions.RecipeNotFoundException;
import exceptions.StepNotFoundException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MX
 */
@Stateless
@Local(StepControllerLocal.class)
public class StepController implements StepControllerLocal {

    @EJB
    private RecipeControllerLocal recipeController;

    @PersistenceContext(unitName = "RedApron-ejbPU")
    private EntityManager em;
    
    
    
    @Override
    public Step createNewStep(Step step){
        em.persist(step);
        em.flush();
        return step;
    }
    
    @Override
    public Step retrieveStepById(long id) throws StepNotFoundException{
        Step step = em.find(Step.class, id);

        if (step != null) {
            return step;
        } else {
            throw new StepNotFoundException("Step does not exist!");
        }
    }
   
    
    @Override
    public List<Step> retrieveAllSteps()
    {
        Query query = em.createQuery("SELECT c FROM Step c");
        
        return query.getResultList();
    }
    
    @Override
   public void updateStep(Step step) throws StepNotFoundException {

        Step stepToUpdate = retrieveStepById(step.getStepId());

        stepToUpdate.setInstruction(step.getInstruction());
        stepToUpdate.setOrderNum(step.getOrderNum());
        stepToUpdate.setImageSrc(step.getImageSrc());
        

    }
   
   @Override
    public List<Step> retrieveStepsByRecipeId(Long id) throws RecipeNotFoundException {
        Recipe recipe = recipeController.retrieveRecipeById(id);
        recipe.getSteps().size();
     
        return recipe.getSteps();
    }
   
    @Override
   public void deleteStep(Step step) throws StepNotFoundException {

        Step stepToDelete = retrieveStepById(step.getStepId());

        em.remove(stepToDelete);
        em.flush();

    }
}
