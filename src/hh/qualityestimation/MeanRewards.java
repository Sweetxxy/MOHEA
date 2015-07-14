/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hh.qualityestimation;

import hh.rewarddefinition.Reward;
import hh.credithistory.ICreditHistory;

/**
 * Aggregates the credits by taking the mean of all credits in history.
 * @author nozomihitomi
 */
public class MeanRewards extends SumRewards{
    private static final long serialVersionUID = -1776736066673232634L;
    
    
    /**
     * Aggregates credit that are sufficiently large. The minimum threshold is 
     * set at 10^-6 the original value of the credit.
     * @param iteration the iteration to attach to the returned credit
     * @param creditHistory the credit history to aggregate over
     * @return 
     */
    @Override
    public Reward aggregateCredit(int iteration, ICreditHistory creditHistory) {
        double creditSum = super.aggregateCredit(iteration, creditHistory).getValue();
        return new Reward(iteration,creditSum/(double)creditHistory.size());
    }
    
}