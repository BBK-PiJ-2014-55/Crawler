# Crawler
WebCrawler
Crawler
WebCrawler A Multithreaded Java Web Crawler

(Design choice is made to increase speed or reduce memory consumption)

A coordinating thread passes URL's to process to worker threads. The worker threads download the HTML pages, parse them, and extract information and links from the page. The link URL's are given back to the coordinating thread. The coordinating thread wraps the URL's in a crawl job, and passes the crawl job to a worker thread.

The worker threads are located in a thread pool. The crawl job object implements either the Runnable or Callable interface, depending on the concrete design of the crawler.

When each page is downloaded and processed by different threads, then multiple pages can be downloaded and processed at the same time. This utilizes both the bandwidth and CPU better. Neither is idle much time. Both CPU and bandwidth is most of the time used to either download or parse pages.
