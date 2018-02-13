package exceptions;

import java.util.List;

public class InvalidInputDataException extends Exception{
    private List<String> errorList;
    public InvalidInputDataException(List<String> errorList){
        super(errorList.toString());
        this.errorList = errorList;
    }
    public List<String> getErrorList(){
        return errorList;
    }
}
