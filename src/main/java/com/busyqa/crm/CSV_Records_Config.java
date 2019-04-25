//package com.busyqa.crm;
///* 4:23 PM
//created by: ajaypalsingh , 2019-01-06
//Project: crm
//*/
//
//
//import com.busyqa.crm.pojo.student.StudentRecordsCSV;
//import com.busyqa.crm.repo.StudentRecordsCSVRepo;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.LineMapper;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//
//import javax.sql.txt.DataSource;
//
//@Configuration
//@EnableBatchProcessing
//public class CSV_Records_Config {
//
//
//    @Autowired
//    private StudentRecordsCSVRepo studentRecordsCSVRepo;
//
//    @Autowired
//    JobBuilderFactory jobBuilderFactory;
//    @Autowired
//    StepBuilderFactory stepBuilderFactory;
//    @Autowired
//    public DataSource dataSource;
//
//
//
////    @Bean
////    public JdbcBatchItemWriter<StudentRecordsCSV> itemWriter(){
////        JdbcBatchItemWriter<StudentRecordsCSV> writer = new JdbcBatchItemWriter<StudentRecordsCSV>();
////        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<StudentRecordsCSV>());
////        writer.setSql("INSERT INTO StudentRecordsCSV(id, firstName, lastName, email, contact, courseType, Status, Batch, Year ) " +
////                "VALUES (:id, :firstName, :lastName, :email, :contact, :courseType, :Status, :Batch, :Year)");
////        writer.setDataSource(dataSource);
////
////        return writer;
////    }
//
////    @Bean
////    public DataSource dataSource() {
////        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
////        dataSource.setUrl("jdbc:mysql://localhost/busyqacrm");
////        dataSource.setUsername("root");
////        dataSource.setPassword("ganabajaeo");
////
////        return dataSource;
////    }
//
//
//    @Bean
//    public Job job(JobBuilderFactory jobBuilderFactory,
//                   StepBuilderFactory stepBuilderFactory,
//                   ItemReader<? extends StudentRecordsCSV> itemReader,
//                   ItemWriter<? super StudentRecordsCSV> itemWriter
//                   )
//    {
//        System.out.println("Job called");
//        Step step = stepBuilderFactory.get("Student_Records_file load")
//                .<StudentRecordsCSV, StudentRecordsCSV> chunk(5)
//                .reader(itemReader)
//                .writer(itemWriter)
//                .build();
//
//        return jobBuilderFactory.get("ETL File load")
//                .incrementer(new RunIdIncrementer())
//                .start(step)
//                //.flow(step)
//                .build();
//
//    }
//
//    @Bean
//    public FlatFileItemReader<StudentRecordsCSV> itemReader(@Value("${input}") Resource resource) {
//
//        System.out.println("reader called");
//
//        FlatFileItemReader<StudentRecordsCSV> flatFileItemReader = new FlatFileItemReader<>();
//        flatFileItemReader.setResource(resource);
//        flatFileItemReader.setName("CSV-Reader");
//        flatFileItemReader.setLinesToSkip(1);
//        flatFileItemReader.setLineMapper(lineMapper());
//        return flatFileItemReader;
//    }
//
////    @Bean
////    public FlatFileItemReader<StudentRecordsCSV> itemReader() {
////
////        System.out.println("reader called");
////
////        FlatFileItemReader<StudentRecordsCSV> flatFileItemReader = new FlatFileItemReader<StudentRecordsCSV>();
////        flatFileItemReader.setResource(new ClassPathResource("students.csv"));
////        flatFileItemReader.setLineMapper(new DefaultLineMapper<StudentRecordsCSV>() {{
////           setLineTokenizer(new DelimitedLineTokenizer() {{
////                setNames(new String[] { "id", "firstName", "lastName", "email", "contact", "CourseType", "Status", "Batch", "Year" });
////            }});
////            setFieldSetMapper(new BeanWrapperFieldSetMapper<StudentRecordsCSV>() {{
////                setTargetType(StudentRecordsCSV.class);
////            }});
////
////        }});
////
////        return flatFileItemReader;
////    }
//
//
//
//    @Bean
//    public LineMapper<StudentRecordsCSV> lineMapper() {
//
//        System.out.println("LineMapper called");
//
//        DefaultLineMapper<StudentRecordsCSV> defaultLineMapper = new DefaultLineMapper<>();
//        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//        lineTokenizer.setDelimiter(",");
//        lineTokenizer.setStrict(false);
//        lineTokenizer.setNames(new String[]{ "firstName", "lastName", "email", "contact", "CourseType", "Status", "Batch", "Year"});
//
//        BeanWrapperFieldSetMapper<StudentRecordsCSV> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
//        fieldSetMapper.setTargetType(StudentRecordsCSV.class);
//
//        defaultLineMapper.setLineTokenizer(lineTokenizer);
//        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
//
//        return defaultLineMapper;
//    }
//
//
//
////    @Bean
////    public JpaItemWriter itemWriter(List<StudentRecordsCSV> studentRecordsCSVList){
////
////        JpaItemWriter writer = new JpaItemWriter();
////        writer.setEntityManagerFactory(emf);
////        return writer;
////
////    }
//}
