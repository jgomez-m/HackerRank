package hacker.rank.customerservice;

import java.util.List;

public class Solution {

    static int howManyAgentsToAdd(int noOfCurrentAgents, List<List<Integer>> callsTimes) {
        int count = 0;
        for(int j=0;j<callsTimes.size();j++){
            for(int i=0;i<callsTimes.size();i++){
                if(i!=j){
                    if(callsTimes.get(i).get(1) >= callsTimes.get(j).get(0) &&
                            callsTimes.get(i).get(1) < callsTimes.get(j).get(1)){
                        count++;
                    }
                }
            }

        }
        return ((count-noOfCurrentAgents) ==0 ? 0: count - noOfCurrentAgents);
    }

}
