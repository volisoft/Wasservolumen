# Wasservolumen
Playing with Java EE 7

Simple EJB bean that calculates volume of water that fills gaps between bars. REST service accessible by 
```
POST:  <context root>/myproject/water/volume
```

The application was tested using WildFly 9.0.1.Final

Request sample:
```json
{
  "relief": [2,1,3]
}
```

Algorithm complexity:
 - Time complexity: best/worst/avg O(n) (makes two traversals in linear time)
 - Space complexity: best/worst/avg O(n) (requires additional array for storing maximum height of a wall from right hand side)
