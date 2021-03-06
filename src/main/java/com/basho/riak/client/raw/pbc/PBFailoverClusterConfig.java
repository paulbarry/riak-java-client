package com.basho.riak.client.raw.pbc;

import com.basho.riak.client.raw.config.ClusterConfig;
import com.basho.riak.client.raw.config.FailoverClusterConfig;

public class PBFailoverClusterConfig  extends FailoverClusterConfig<PBClientConfig>
{
  public PBFailoverClusterConfig(int totalMaximumConnections) {
    super(totalMaximumConnections);
  }

  @Override public ClusterConfig<PBClientConfig> addHosts(String... hosts) {
    return addHosts(PBClientConfig.defaults(), hosts);
  }

  @Override public ClusterConfig<PBClientConfig> addHosts(PBClientConfig config, String... hosts) {
    PBClientConfig.Builder b = PBClientConfig.Builder.from(config);

    for(String host : hosts) {
      addClient(b.withHost(host).build());
    }

    return this;
  }
}
