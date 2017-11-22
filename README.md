## Save to Database Annotation

Save model to database at runtime ( RetentionPolicy.RUNTIME) , using custom annotations and reflection.

- @TableName ( Target = ElementType.TYPE - over class)
- @DatabaseColumn ( Target = ElementType.FIELD - over fields)

mySQL Database used.

## Examples:

@TableName(tableName = "PersonsTable")
 public class Person{}

@DatabaseColumn(columnName = "NAME")
 private String name;

### Technologies / Frameworks: 

Java 8, Reflection API, Maven, SQL
