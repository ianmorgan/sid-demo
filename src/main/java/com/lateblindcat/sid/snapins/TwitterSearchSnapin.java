package com.lateblindcat.sid.snapins;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import com.lateblindcat.sid.core.fp.ExpressionFactory;
import com.lateblindcat.sid.core.framework.Route;
import com.lateblindcat.sid.framework.pages.PageResponse;
import com.lateblindcat.sid.framework.pages.PageResponseFactory;
import com.lateblindcat.sid.rack.RackRequest;

public class TwitterSearchSnapin implements Snapin {

	@Override
	public String getName() {
		return "Twitter Search";
	}

	@Override
	public Route getRoute() {
		return new Route("GET:/dotwittersearch/*");
	}

	@Override
	public PageResponse process(RackRequest request) {
		Twitter twitter = new TwitterFactory().getInstance();
		String q = "dartford";
		if (request.params().containsKey("q") ) {
			q = request.params().get("q");
		}
		Query query = new Query(q);
		query.setPage(1);

		QueryResult result = null;
		StringBuilder sb = new StringBuilder();

		try {
			result = twitter.search(query);

			sb.append("<div>Searching for <strong>").append(q).append("</strong></div>");

			sb.append("<div><pre>results");
			sb.append(("page " + result.getPage()));
			for (Object t : result.getTweets()) {
				Tweet tweet = (Tweet) t; // unknown prob compiling on Ubuntu
				sb.append("\n");
				sb.append(tweet.getCreatedAt() + " - " + tweet.getFromUser() + ":" + tweet.getText() + ":"
						+ tweet.getLocation());
			}
			sb.append("</pre></div>");

		} catch (TwitterException e) {
			sb.append(e.getMessage());
		}

		return PageResponseFactory.text(ExpressionFactory.string(sb));
	}

}
