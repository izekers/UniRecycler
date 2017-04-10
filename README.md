# Zoker
在平常开发中，发现RecyclerView经常有着许多不同的需求，而这些需求往往能够在其他项目中复用，这里我尝试自己来打造一个能适应不同情况的RecyclerView。
一个是便于日后开发，另一个也当作是锻炼自己吧。


计划一下接下来的实现目标吧：
1. 添加FooterView和HeaderView;
2. 上下拉刷新;
3. 待续。。

  引用了鸿洋大神的HeaderAndFooterWrapper，用于实现FooterView和HeaderView的功能，但存在着一些Bug或问题
  1. 界面显示后，中途修改LayoutManager会导致Grid布局的HeaderView和FooterView布局混乱，问题原因是onAttachedToReyclerView没有被再次引用到，需要研究以下再做修改；
  2. 直接更新自定义的adapter不能更新，需要更新HeaderAndFooterWrapper才能更新到，需要考虑怎么优化；

