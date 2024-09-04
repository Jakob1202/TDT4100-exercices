package oving6.delegation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {
    private Map<Employee, List<String>> printedDocuments = new HashMap<>();

    /**
     * Method to print a document
     * 
     * @param document the document to be printed
     * @param employee the employee who print the document
     */
    public void printDocument(String document, Employee employee) {
        List<String> documentsList = this.printedDocuments.get(employee);
        if (documentsList == null) {
            documentsList = new ArrayList<>();
            printedDocuments.put(employee, documentsList);
        }
        documentsList.add(document);
    }

    /**
     * Method to get the print history to the employee
     * 
     * @param employee the emplyee
     * @return a list with all the documents printed by the employee, an empty list
     *         if the employee have not printed any documents
     */
    public List<String> getPrintHistory(Employee employee) {
        List<String> documentsList = this.printedDocuments.get(employee);
        if (documentsList == null) {
            documentsList = new ArrayList<>();
            printedDocuments.put(employee, documentsList);
        }
        return new ArrayList<>(this.printedDocuments.get(employee));

    }

}
