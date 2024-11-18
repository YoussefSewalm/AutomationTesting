package stepDefinitions;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
public class JSONFileModifier {
	
 private static File JsonFile;
 private static ObjectNode JsonNode;
 
private static ObjectMapper OpenFile(String FilePath) throws StreamReadException, DatabindException, IOException
 //Function Returns ObjectMapper Type --Static 3shan keda keda msh deh 2ly h3mlha access w ana b7ot l data
//l functin 2ly esmha ModifyValue 2ly t7tha hya 2ly hst5dmha 3shan keda Public
 {
	 JsonFile=new File(FilePath);
	 ObjectMapper objectmapper=new ObjectMapper();
	 JsonNode=objectmapper.readValue(JsonFile,ObjectNode.class);
	 return objectmapper;
 }
	//Now All Data Needed From JSONFILE is Ready in the <<<JsonNode>>>
public static void ModifyValue(String filepath,String key,String newvalue) throws StreamReadException, DatabindException, IOException
{
	ObjectMapper mapper=OpenFile(filepath);
	JsonNode.put(key,newvalue);
	//Map The Updated Json back to the file (JsonFile)
	mapper.writeValue(JsonFile, JsonNode);
}

}
