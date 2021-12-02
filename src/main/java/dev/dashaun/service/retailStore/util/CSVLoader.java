package dev.dashaun.service.retailStore.util;

import dev.dashaun.service.retailStore.domain.StoreJPA;
import dev.dashaun.service.retailStore.domain.StoreRedis;
import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class CSVLoader {


    public static void redis(CrudRepository<StoreRedis, String> repository) {
        try {
            File file = ResourceUtils.getFile("classpath:Retail_Food_Stores.csv");
            CsvReader csvReader = new CsvReader();
            csvReader.setContainsHeader(true);
            CsvContainer csv = csvReader.read(file, StandardCharsets.UTF_8);
            for (CsvRow row : csv.getRows()) {
                repository.save(convertToRedis(row));
            }
        } catch (IOException ioe) {
            log.error(ioe.getMessage());
        }
    }

    public static void jpa(CrudRepository<StoreJPA, String> repository) {
        try {
            File file = ResourceUtils.getFile("classpath:Retail_Food_Stores.csv");
            CsvReader csvReader = new CsvReader();
            csvReader.setContainsHeader(true);
            CsvContainer csv = csvReader.read(file, StandardCharsets.UTF_8);
            for (CsvRow row : csv.getRows()) {
                repository.save(convertToJPA(row));
            }
        } catch (IOException ioe) {
            log.error(ioe.getMessage());
        }
    }

    public static StoreRedis convertToRedis(CsvRow row) {
        return StoreRedis.builder()
                .County(row.getField(0))
                .License_Number(row.getField(1))
                .Operation_Type(row.getField(2))
                .Establishment_Type(row.getField(2))
                .Entity_Name(row.getField(2))
                .DBA_Name(row.getField(2))
                .Street_Number(row.getField(2))
                .Street_Name(row.getField(2))
                .Address_Line_2(row.getField(2))
                .Address_Line_3(row.getField(2))
                .City(row.getField(2))
                .State(row.getField(2))
                .Zip_Code(row.getField(2))
                .Square_Footage(row.getField(2))
                .Location(row.getField(2))
                .build();
    }

    public static StoreJPA convertToJPA(CsvRow row) {
        return StoreJPA.builder()
                .County(row.getField(0))
                .License_Number(row.getField(1))
                .Operation_Type(row.getField(2))
                .Establishment_Type(row.getField(2))
                .Entity_Name(row.getField(2))
                .DBA_Name(row.getField(2))
                .Street_Number(row.getField(2))
                .Street_Name(row.getField(2))
                .Address_Line_2(row.getField(2))
                .Address_Line_3(row.getField(2))
                .City(row.getField(2))
                .State(row.getField(2))
                .Zip_Code(row.getField(2))
                .Square_Footage(row.getField(2))
                .Location(row.getField(2))
                .build();
    }
}
