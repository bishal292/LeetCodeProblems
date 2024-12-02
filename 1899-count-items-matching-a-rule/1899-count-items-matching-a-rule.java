class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count =0,rule;
        if(ruleKey.equals("type")){
            rule=0;
        }else if(ruleKey.equals("color")){
            rule=1;
        }else{
            rule=2;
        }
        for(List<String> item: items){
            if(item.get(rule).equals(ruleValue)){
                count++;
            }
        }

        return count;
    }
}