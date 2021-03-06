<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		<s:iterator value="cats" var="c1">
			<!--1级分类开始-->
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[
					<s:property value="#c1.name" />
					]
				</h3>
				<ul class="ul_left_list">
					<s:iterator value="#c1.subCats" var="c2">
						<!--2级分类开始-->
						<li>
							<a id="blackLeft_<s:property value='#c2.id'/>"
								onmouseout="moveBlackLeft(<s:property value='#c2.id'/>);"
								onmouseover="addBlackLeft(<s:property value='#c2.id'/>);"
								title="查看此分类"
								href='book_list.action?cid=<s:property value="#c2.id"/>&pid=<s:property value="#c1.id"/>'><s:property
									value="#c2.name" /> </a>
						</li>
						<!--2级分类结束-->
					</s:iterator>
				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
			<!--1级分类结束-->
		</s:iterator>
		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
