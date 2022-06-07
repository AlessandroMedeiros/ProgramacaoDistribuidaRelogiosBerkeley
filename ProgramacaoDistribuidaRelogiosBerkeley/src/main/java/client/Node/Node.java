package client.Node;

import java.time.LocalTime;

public class Node {
  private int id;
  private String host;
  private int port;
  private LocalTime time;
  private long ptime;
  private int adelay;

  public Node(int id, String host, int port, LocalTime time, long ptime, int adelay) {
    this.id = id;
    this.host = host;
    this.port = port;
    this.time = LocalTime.now();
    this.ptime = ptime;
    this.adelay = adelay;
  }

  public int getId() {
    return id;
  }

  public String host() {
    return host;
  }

  public int port() {
    return port;
  }

  public LocalTime time() {
    return time;
  }

  public long ptime() {
    return ptime;
  }

  public int adelay() {
    // TODO calcular atraso
    return adelay;
  }
}
