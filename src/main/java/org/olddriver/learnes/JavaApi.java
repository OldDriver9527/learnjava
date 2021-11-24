package org.olddriver.learnes;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.stream.Stream;

/**
 * Java Api
 * 20211121
 * 第九部分
 */
public class JavaApi {
    /**
     * es提供两类客户端
     * TransPort Client 早期使用，已不推荐使用，8.0版本将移除
     * Rest Client
     *
     *
     */

    @Test
    public void testRestHighLevelClient(){
        try (RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));){
            testGet(client);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void testGet(RestHighLevelClient client) throws IOException {

        GetRequest request = new GetRequest("test", "_doc", "1");
        GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);

        getResponse.getSourceAsMap().entrySet().stream().forEach((ele)->{
            System.out.println(ele.getKey()+"--"+ele.getValue());
        });

    }

    @Test
    public void testTransportClient(){

        Settings settings = Settings.builder()
                .put("cluster.name","my-application")
                .put("node.name","node-1")
                .put("http.cors.enabled",Boolean.TRUE)
                .put("http.cors.allow-origin","*")
                .build();

        try (TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9300));){

            testQuery(client);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testQuery(TransportClient client){

        SearchResponse searchResponse = client.prepareSearch("test")
                .setQuery(QueryBuilders
                            .matchQuery("name","小米"))
                .get();

        SearchHits hits = searchResponse.getHits();
        SearchHit[] hitsArr = hits.getHits();

        Stream.of(hitsArr).forEach((SearchHit ele)->{
            System.out.println(ele.getSourceAsMap().get("name"));
            System.out.println(ele.getSourceAsMap().get("desc"));
            System.out.println(ele.getSourceAsMap().get("price"));
            System.out.println(ele.getSourceAsMap().get("tags"));
        });

    }

    public void testDelete(TransportClient client){
        DeleteResponse deleteResponse = client.prepareDelete("test", "_doc", "5").get();
        System.out.println(deleteResponse);
    }

    public void testUpdate(TransportClient client) throws IOException {
        UpdateResponse updateResponse = client.prepareUpdate("test", "_doc", "2")
                .setDoc(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name", "小米nfc手机")
                        .endObject())
                .get();

        System.out.println(updateResponse);
    }

    public void testGetAll(TransportClient client){
        SearchResponse searchResponse = client.prepareSearch("test").get();
        SearchHits hits = searchResponse.getHits();
        SearchHit[] hitsArr = hits.getHits();

        Stream.of(hitsArr).forEach((SearchHit ele)->{
            System.out.println(ele.getSourceAsMap().get("name"));
            System.out.println(ele.getSourceAsMap().get("desc"));
            System.out.println(ele.getSourceAsMap().get("price"));
            System.out.println(ele.getSourceAsMap().get("tags"));
        });


    }

    public void testGet(TransportClient client){
        GetResponse getResponse = client.prepareGet("test", "_doc", "1").get();

        System.out.println(getResponse.getIndex());
        System.out.println(getResponse.getType());
        System.out.println(getResponse.getId());
        System.out.println(getResponse.getSource().get("name"));
        System.out.println(getResponse.getSource().get("tags"));

    }
    
    
    public void testCreate(TransportClient client) throws IOException {
        IndexResponse indexResponse = client.prepareIndex("test", "_doc", "1")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name","小米手机")
                        .field("desc","手机中的战斗机")
                        .field("price",1999)
                        .field("tags", new String[]{"性价比"})
                        .endObject())
                .get();

        System.out.println(indexResponse);
    }

}
