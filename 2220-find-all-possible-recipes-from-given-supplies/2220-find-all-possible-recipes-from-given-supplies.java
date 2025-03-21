class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        int[] visited = new int[n];
        List<String> result = new ArrayList<>();
       

        for(int i = 0; i < n ; i++){
            dfs(Arrays.asList(recipes), ingredients, Arrays.asList(supplies), visited, i);
        }
        for(int i=0; i< visited.length; i++){
            if(visited[i] == 1){
                result.add(recipes[i]);
            }
        }

        return result;
    }

    public boolean dfs(List<String> recipies, List<List<String>> ingredients, List<String> supplies, int[] visited, int index){
        if(visited[index] == 1) return true;
        if(visited[index] == -1) return false;
        List<String> ingredientList = ingredients.get(index);

        visited[index] = -1;
        for(String ingredient: ingredientList){
            if(!supplies.contains(ingredient)) {
                if(recipies.contains(ingredient)){
                    int idx = recipies.indexOf(ingredient);
                    boolean isSupplyAvailable = dfs(recipies, ingredients, supplies, visited, idx);
                    if(!isSupplyAvailable){
                       return false;
                    }
                }else{
                    return false;
                }
            }
        }
        visited[index] = 1;

        return true;
        
    }
}