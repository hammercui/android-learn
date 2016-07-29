package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class ExampleDaoGenerator {
    public static void main(String args[]){
        // 正如你所见的，你创建了一个用于添加实体（Entity）的模式（Schema）对象。
        // 两个参数分别代表：数据库版本号与自动生成代码的包路径。
        Schema schema = new Schema(100010, "com.hammer.example");
        //当然，如果你愿意，你也可以分别指定生成的 Bean 与 DAO 类所在的目录，只要如下所示：
        // 一旦你拥有了一个 Schema 对象后，你便可以使用它添加实体（Entities）了。
        addNote(schema);
        // 最后我们将使用 DAOGenerator 类的 generateAll() 方法自动生成代码，此处你需要根据自己的情况更改输出目录（既之前创建的 java-gen)。
        // 其实，输出目录的路径可以在 build.gradle 中设置，有兴趣的朋友可以自行搜索，这里就不再详解。
        try {
            new DaoGenerator().generateAll(schema, "E:/androidSpace/android-lesson/app/src/main/java-gen");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param schema
     */
    private static void addNote(Schema schema) {
        // 一个实体（类）就关联到数据库中的一张表，此处表名为「Note」（既类名）
        Entity note = schema.addEntity("Note");
        // 你也可以重新给表命名
        // note.setTableName("NODE");
        // greenDAO 会自动根据实体类的属性值来创建表字段，并赋予默认值
        // 接下来你便可以设置表中的字段：
        note.addIdProperty();
        note.addStringProperty("text").notNull();
        // 与在 Java 中使用驼峰命名法不同，默认数据库中的命名是使用大写和下划线来分割单词的。
        // For example, a property called “creationDate” will become a database column “CREATION_DATE”.
        note.addStringProperty("comment");
        note.addDateProperty("date");
        //note.addStringProperty("testId");
        creatEntity(schema);
    }

    private static void creatEntity(Schema schema){
        //创建课程
        Entity entity1 = schema.addEntity("Lesson");
        entity1.addIdProperty();
        entity1.addStringProperty("name").notNull();
        entity1.addStringProperty("description");
        entity1.addIntProperty("typeId");;

        //创建课程
        Entity entity2 = schema.addEntity("Zhang");
        entity2.addIdProperty();
        entity2.addStringProperty("name").notNull();
        entity2.addStringProperty("description");
        entity2.addIntProperty("typeId");;
    }
}
