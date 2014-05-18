# Apache Thrift POJO Generator Maven Plugin

Apache Thrift generates rich classes with direct dependencies to some of its own. This is very inconvenient when you want to use it on GWT, as you would need to include the Thrift source code in your GWT project.

**This maven plugin allow you to create POJOs out of Thrift Java classes to use them in GWT**, the resulting java classes are plain POJOs plus Bridge classes that allow you to convert Thrift files to POJO and back.

Some details:

- All Thrift types are supported
- Can deal with the collections (set, list and map)
- Works with references, including collections. A reference to a Thrift object inside of another Thrift object within a collection in Thrift? No problem, the plugin will take care of it up to many levels you want to throw to it.
- Auto generated HashCode and Equals
- Bridge classes to transform from Thrift object to POJOs and back

And some limitations:

- Only works with Java

## Maven Plugin Usage

Install this Maven plugin and add the following configuration to your pom.xml file


	<build>
        [ ... ]
		<plugins>
		[ ... ]
            <plugin>
                <groupId>org.disges</groupId>
                <artifactId>thrift-pojo-generator-maven-plugin</artifactId>
                <version>1.0</version>
                <executions>
                    <execution>
                        <id>generate</id>
                        <goals>
                            <goal>generate-sources</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <sources>
                        <source>${basedir}/src/main/java</source>
                    </sources>
                    <packageBaseList>
                        <packageBase>your.project.thrift.classes.package</packageBase>
                    </packageBaseList>
                    <destinationPackage>your.project.pojo.classes.package</destinationPackage>
                    <outputPostfix>Pojo</outputPostfix>
                    <interfaceName>java.io.Serializable</interfaceName>
                </configuration>
            </plugin>
        </plugins>
    </build>

When Maven runs the *generate-source* goal the plugin will scan all files in your source directory and subfolders and generate a POJO for all the Thrift classes that it finds. Because *packageBaseList* is defined only classes on this package will be scanned.
The generated classes will be added to *your.project.pojo.classes.package*, conserving the package structure. The files will have the same name than the original plus the postfix specify (Pojo in this case).

### Configuration parameters

#### sources
Specify your project source directory
#### outputDirectory (Optional, default "target/generated-sources")
The output directory for the generated POJOs
#### outputPostfix (Optional, default "Pojo")
Postfix for the generated POJOs. Example: a Thrift class "House.java" will generate "HousePojo.java" if the postfix is "Pojo"
#### interfaceName (Optional)
String representation of all the interfaces you might want to implement. Typically you always want to implement Serializable for GWT project, but you can add any other here if you want. Example: "java.io.Serializable, java.other.package.Class"
#### destinationPackage
Where the generated POJOs will be persisted
#### packageBaseList (Optional)
If defined, only classes on those package will generate POJOs. If omitted all the Thrift classes in the source directory (and subfolders) will generate a POJO
#### includeFieldsEnum (Optional, default False)
If True the plugin will include an Enum called Fields contained an entry for each of the variables in the class

## Generated POJOs
For each Thrift class the plugin will generate two classes:
- *Pojo*: A simple representation of the object
- *Bridge*: Utility class to convert from Thrift classes to POJOs and back

Example:

Given the following Thrift definition:

    namespace java thrift.pojo.test.testdata.included.package1
    
    struct SimpleStruct {
        1: required string name;
    }

Thrift will generate a 378 lines long class. The plugin will produce two classes: SimpleStructPojo and SimpleStructPojoBridge

    package thrift.pojo.test.pojo.package1;
    
    public class SimpleStructPojo implements java.io.Serializable {
        private java.lang.String name;
    
        public SimpleStructPojo() {
            super();
        }
    
        public SimpleStructPojo(java.lang.String name) {
            super();
    
            this.name = name;
        }
    
    
        // Getters and Setters
        public java.lang.String getName() {
               return name;
        }
        public void setName(java.lang.String name) {
               this.name = name;
        }
    
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
    
            SimpleStructPojo that = (SimpleStructPojo) o;
    
            if (name != null ? !name.equals(that.name) : that.name != null) return false;
    
            return true;
        }
    
        @Override
        public int hashCode() {
            int result = (name != null ? (name.hashCode() * 31) : 0);
    
            return result;
        }
    }

Bridge:

    package thrift.pojo.test.pojo.package1;
    
    public class SimpleStructPojoBridge {
    
        public static SimpleStructPojo getPojoRepresentation(thrift.pojo.test.testdata.included.package1.SimpleStruct remote) {
            return new SimpleStructPojo(remote.name);
        }
    
        public static thrift.pojo.test.testdata.included.package1.SimpleStruct getRemoteRepresentation(SimpleStructPojo pojo){
            return new thrift.pojo.test.testdata.included.package1.SimpleStruct(pojo.getName());
        }
    
        public static java.util.Set<thrift.pojo.test.testdata.included.package1.SimpleStruct> getRemoteRepresentationCollection(java.util.Set<SimpleStructPojo> pojoSet) {
            java.util.Set<thrift.pojo.test.testdata.included.package1.SimpleStruct> remoteRepresentationCollection = new java.util.HashSet<thrift.pojo.test.testdata.included.package1.SimpleStruct>();
            for (SimpleStructPojo pojo : pojoSet) {
                remoteRepresentationCollection.add(SimpleStructPojoBridge.getRemoteRepresentation(pojo));
            }
    
            return remoteRepresentationCollection;
        }
    
        public static java.util.Set<SimpleStructPojo> getPojoRepresentationCollection(java.util.Set<thrift.pojo.test.testdata.included.package1.SimpleStruct> pojoSet) {
            java.util.Set<SimpleStructPojo> pojoRepresentationCollection = new java.util.HashSet<SimpleStructPojo>();
            for (thrift.pojo.test.testdata.included.package1.SimpleStruct remote : pojoSet) {
                pojoRepresentationCollection.add(SimpleStructPojoBridge.getPojoRepresentation(remote));
            }
    
            return pojoRepresentationCollection;
        }
    
        public static java.util.List<thrift.pojo.test.testdata.included.package1.SimpleStruct> getRemoteRepresentationCollection(java.util.List<SimpleStructPojo> pojoSet) {
            java.util.List<thrift.pojo.test.testdata.included.package1.SimpleStruct> remoteRepresentationCollection = new java.util.ArrayList<thrift.pojo.test.testdata.included.package1.SimpleStruct>();
            for (SimpleStructPojo pojo : pojoSet) {
                remoteRepresentationCollection.add(SimpleStructPojoBridge.getRemoteRepresentation(pojo));
            }
    
            return remoteRepresentationCollection;
        }
    
        public static java.util.List<SimpleStructPojo> getPojoRepresentationCollection(java.util.List<thrift.pojo.test.testdata.included.package1.SimpleStruct> pojoSet) {
            java.util.List<SimpleStructPojo> pojoRepresentationCollection = new java.util.ArrayList<SimpleStructPojo>();
            for (thrift.pojo.test.testdata.included.package1.SimpleStruct remote : pojoSet) {
                pojoRepresentationCollection.add(SimpleStructPojoBridge.getPojoRepresentation(remote));
            }
    
            return pojoRepresentationCollection;
        }
    
    }

### POJOs usage

Lets say that you want to use SimpleStruct to communicate your GWT project with an external server, you would generate the POJO classes out of the Thrift ones (see generated code in previous section). 
This would be done by Maven each time you run the *generate-code* goal (included in *install* and others). It is ok to use Thrift classes in the server side, but you can't use them easily on the client side (it would need the Thrift source code for the javaScript generated code),
 so when you want to send your Thrift classes to the client you would transform them to their POJO counterpart:
 
    SimpleStruct simpleStruct = [ ... ]

    // Transforming to POJO
    SimpleStructPojo simpleStructPojo = SimpleStructPojoBridge.getPojoRepresentation(simpleStruct);
    [ ... ]
    // Do your thing here: send it to GWT, manipulate the object... etc
    [ ... ]
    // We need to send the Thrift back, so lets reconvert it
    SimpleStruct simpleStructReconverted = SimpleStructPojoBridge.getRemoteRepresentation(simpleStructPojo);
    
There are some utility methods for Collections:

    List<SimpleStruct> simpleStructList = [ ... ]
    [ ... ]
    List<SimpleStructPojo> simpleStructPojoList = SimpleStructPojoBridge.getPojoRepresentationCollection(simpleStructList);
    [ ... ]
    List<SimpleStruct> simpleStructListReconverted = SimpleStructPojoBridge.getRemoteRepresentationCollection(simpleStructPojoList);
