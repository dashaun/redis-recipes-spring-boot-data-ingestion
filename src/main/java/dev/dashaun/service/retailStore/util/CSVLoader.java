package dev.dashaun.service.retailStore.util;

import de.siegmar.fastcsv.reader.NamedCsvReader;
import de.siegmar.fastcsv.reader.NamedCsvRow;
import dev.dashaun.service.retailStore.domain.StoreJPA;
import dev.dashaun.service.retailStore.domain.StoreRedis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.CrudRepository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CSVLoader {
    
    private final Resource csv;
    
    public CSVLoader(Resource csv) {
        this.csv = csv;
    }
    
    public List<NamedCsvRow> readDataIntoRows() throws IOException {
        NamedCsvReader csvReader = NamedCsvReader.builder().build(new InputStreamReader(csv.getInputStream()));
        return csvReader.stream().collect(Collectors.toList());
    }

    public void redis(CrudRepository<StoreRedis, String> repository) {
        try {
            List<NamedCsvRow> data = readDataIntoRows();
            for (NamedCsvRow row : data) {
                repository.save(convertToRedis(row));
            }
        } catch (IOException ioe) {
            log.error(ioe.getMessage());
        }
    }

    public void jpa(CrudRepository<StoreJPA, String> repository) {
        try {
            List<NamedCsvRow> data = readDataIntoRows();
            for (NamedCsvRow row : data) {
                repository.save(convertToJPA(row));
            }
        } catch (IOException ioe) {
            log.error(ioe.getMessage());
        }
    }

    public static StoreRedis convertToRedis(NamedCsvRow row) {
        return StoreRedis.builder()
                .County(row.getField("County"))
                .License_Number(row.getField("License Number"))
                .Operation_Type(row.getField("Operation Type"))
                .Establishment_Type(row.getField("Establishment Type"))
                .Entity_Name(row.getField("Entity Name"))
                .DBA_Name(row.getField("DBA Name"))
                .Street_Number(row.getField("Street Number"))
                .Street_Name(row.getField("Street Name"))
                .Address_Line_2(row.getField("Address Line 2"))
                .Address_Line_3(row.getField("Address Line 3"))
                .City(row.getField("City"))
                .State(row.getField("State"))
                .Zip_Code(row.getField("Zip Code"))
                .Square_Footage(row.getField("Square Footage"))
                .Location(row.getField("Location"))
                .build();
    }

    public static StoreJPA convertToJPA(NamedCsvRow row) {
        return StoreJPA.builder()
                .County(row.getField("County"))
                .License_Number(row.getField("License Number"))
                .Operation_Type(row.getField("Operation Type"))
                .Establishment_Type(row.getField("Establishment Type"))
                .Entity_Name(row.getField("Entity Name"))
                .DBA_Name(row.getField("DBA Name"))
                .Street_Number(row.getField("Street Number"))
                .Street_Name(row.getField("Street Name"))
                .Address_Line_2(row.getField("Address Line 2"))
                .Address_Line_3(row.getField("Address Line 3"))
                .City(row.getField("City"))
                .State(row.getField("State"))
                .Zip_Code(row.getField("Zip Code"))
                .Square_Footage(row.getField("Square Footage"))
                .Location(row.getField("Location"))
                .build();
    }
}
