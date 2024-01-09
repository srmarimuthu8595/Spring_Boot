package snippet;

public class Snippet {
	<?xml version="1.0" encoding="UTF-8" ?>
	<entity-mappings xmlns="http://xmlns.jcp.org/xml/ns/persistence/orm"
	                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	                 xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence/orm
	                                     http://xmlns.jcp.org/xml/ns/persistence/orm_2_0.xsd" version="2.1">
	
	    <!-- JPA Named Queries -->
	    <named-query name="Book.findAll">
	        <query>SELECT b FROM Book b</query>
	    </named-query>
	    <named-query name="Book.findById">
	        <query>SELECT b FROM Book b WHERE b.id = :id</query>
	    </named-query>
	
	    <!-- entity mapping -->
	    <entity class="com.memorynotfound.hibernate.Book">
	        <attributes>
	            <basic name="title"/>
	        </attributes>
	    </entity>
	
	</entity-mappings>
}

