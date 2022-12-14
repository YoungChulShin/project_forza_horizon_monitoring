package project.forzadata.monitoring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigException;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;

public class ElasticSearchSinkConnector extends SinkConnector {

  private Map<String, String> configProperties;

  @Override
  public void start(Map<String, String> props) {
    this.configProperties = props;
    try {
      // 입력 값을 기준으로 config를 생성
      new ElasticSearchSinkConnectorConfig(props);
    } catch (ConfigException e) {
      throw new ConfigException(e.getMessage(), e);
    }
  }

  @Override
  public Class<? extends Task> taskClass() {
    return ElasticSearchSinkTask.class;
  }

  @Override
  public List<Map<String, String>> taskConfigs(int maxTasks) {
    List<Map<String, String>> taskConfigs = new ArrayList<>();
    Map<String, String> taskProps = new HashMap<>(configProperties);

    for (int i = 0; i < maxTasks; i++) {
      taskConfigs.add(taskProps);
    }

    return taskConfigs;
  }

  @Override
  public void stop() {

  }

  @Override
  public ConfigDef config() {
    return ElasticSearchSinkConnectorConfig.CONFIG;
  }

  @Override
  public String version() {
    return "1.0";
  }
}
