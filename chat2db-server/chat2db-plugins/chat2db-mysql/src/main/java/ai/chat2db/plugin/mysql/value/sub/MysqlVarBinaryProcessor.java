package ai.chat2db.plugin.mysql.value.sub;

import ai.chat2db.spi.model.JDBCDataValue;
import ai.chat2db.spi.model.SQLDataValue;
import ai.chat2db.spi.sql.Chat2DBContext;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: zgq
 * @date: 2024年06月03日 20:48
 */
@Slf4j
public class MysqlVarBinaryProcessor extends MysqlBinaryProcessor {

    @Override
    public String convertSQLValueByType(SQLDataValue dataValue) {
        // TODO: insert file
        return super.convertSQLValueByType(dataValue);
    }


    @Override
    public String convertJDBCValueByType(JDBCDataValue dataValue) {
        try {
            return dataValue.getBlobString(true);
        } catch (Exception e) {
            log.warn("convertJDBCValueByType error database: {} , error dataType: {} ",
                     Chat2DBContext.getDBConfig().getDbType(), dataValue.getType(), e);
            return super.convertJDBCValueByType(dataValue);
        }
    }


    @Override
    public String convertJDBCValueStrByType(JDBCDataValue dataValue) {
        return super.convertJDBCValueStrByType(dataValue);
    }
}

