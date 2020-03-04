package amazon;
import java.util.*;
import java.util.stream.Collectors;

/**
 * You work on Kindle team and are trying to understand which features users want added to a new version of the kindle
 * the most. Your team has received a large number of feature requests from users
 * Write an algorithm that identifies the most popular N feature requests out of a list of feature requests and possible
 * feature. Your algorithm should output the most-frequently mentioned features.
 *
 * Note: The comparision of strings is case-insensitive
 * - If the value of topFeatures is more than the number of possible features, return the names of only the features
 *   mentioned in the feature requests.
 * - Multiple occurrence of a feature in a quote should be considered as a single mention
 * - If features are mentioned an equal number of times in feature requests (eg newshop=2, shopnew=2, mymarket=4)
 *   sort alphabetically. topFeatures=2, Output = [mymarket, newshop]
 */

class PopularNFeatures
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests)
    {
        if(numFeatures == 0 || numFeatureRequests == 0) return new ArrayList<>();

        Map<String, Integer> mapOfFeatures = new HashMap<>(numFeatures);
        for(String feature : possibleFeatures){
            for(String request : featureRequests){
                if(request.toLowerCase().contains(feature.toLowerCase())){
                    if(!mapOfFeatures.containsKey(feature)){
                        mapOfFeatures.put(feature, 1);
                    }
                    else{
                        int num = mapOfFeatures.get(feature);
                        mapOfFeatures.put(feature, num + 1);
                    }
                }
            }
        }
        System.out.println(mapOfFeatures);

        return topOfFeatures(mapOfFeatures, topFeatures);
    }

    private List<String> topOfFeatures(Map<String, Integer> mapOfFeatures, int topFeatures)
    {
        List<Map.Entry<String, Integer>> entryList= new ArrayList<>(mapOfFeatures.entrySet());

        Collections.sort(entryList, (a, b) ->
                (b.getValue() - a.getValue()) != 0 ? (b.getValue() - a.getValue()) : a.getKey().compareTo(b.getKey()));

        return entryList.stream().limit(topFeatures)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        int numFeatures = 6;
        int topFeatures = 3;
        List<String> possibleFeatures = Arrays.asList("storage", "battery", "hover", "alexa", "waterproof", "solar");
        int numFeatureRequests = 7;
        List<String> featureRequests = Arrays.asList("I wish my kindle had even more storage",
                "I wish the battery, life on my Kindle lasted 2 years",
                "I read in the bath I would enjoy a waterproof in the kindle",
                "Waterproof and increased BATTERY are my top 2 requests",
                "I wish my kindle was solar charge",
                "I Wish my kindle could have connect with my hover",
                "I wish my kindle had connection with alexa system");;
        List<String> result = new PopularNFeatures().popularNFeatures(numFeatures, topFeatures, possibleFeatures, numFeatureRequests, featureRequests);
        System.out.println(result);
    }
}