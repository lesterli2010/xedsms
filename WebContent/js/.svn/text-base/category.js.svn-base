// category.js

zk.$package('ngdir');
zk.load('zul.wgt', function () {
ngdir.Categorybar = zk.$extends(zul.wgt.Div, {
	bind_: function () {
		this.$supers('bind_', arguments);
		zk(this.$n()).disableSelection();
		
		zWatch.listen({onSize: this, beforeSize: this});
		this.onChildAdded_();//for updating sum of category width
		this.scrollEvent = false;
	},
	unbind_: function () {
		zWatch.unlisten({onSize: this, beforeSize: this});
		this.$supers('unbind_', arguments);
	},
	beforeSize: zk.ie6_ ? function(){
			this.$n("body").style.width = "";
			jq(this.$n("body")).removeClass("ngdirweb-categorybar-body-scroll");
	}: zk.$void,
	onSize: function(){	
		var width = this.$n().offsetWidth;
		//with scorll or not
		if(width < this.childWidth){
			jq(this.$n("left")).addClass("ngdirweb-categorybar-left-scroll");
			jq(this.$n("right")).addClass("ngdirweb-categorybar-right-scroll");
			jq(this.$n("body")).addClass("ngdirweb-categorybar-body-scroll")
								.width((width-40)+"px");
			this._addScollEvent();	
		}else{
			jq(this.$n("left")).removeClass("ngdirweb-categorybar-left-scroll");
			jq(this.$n("right")).removeClass("ngdirweb-categorybar-right-scroll");
			jq(this.$n("body")).removeClass("ngdirweb-categorybar-body-scroll")
								.width(width+"px");
			this.$n("cave").style.marginLeft="0px";
		}
		
	},
	_addScollEvent:function(){
		//update the animiation distance every time it called
		this.$n("cave").distance = jq(this.$n("body")).width() - this.childWidth;
		
		if(this.scrollEvent == false){	//only do at first time
			var cave = this.$n("cave");
			jq(this.$n("left"))
			.mouseover(function(){
				jq(cave).animate({
					marginLeft: "0px"
				},400);
			})
			.mouseout(function(){
				jq(cave).stop(true);
			});
			
			jq(this.$n("right"))
			.mouseover(function(){
				jq(cave).animate({
					marginLeft: cave.distance + "px"
				},400);
			})
			.mouseout(function(){
				jq(cave).stop(true);
			});	
			this.scrollEvent = true;
		}
	},
	onChildAdded_: function (/*child*/) {
		if(this.desktop){
			var childWidth=0;
			jq(this.$n("cave")).children().each(
				function(){
					childWidth += jq(this).width();
			});
			jq(this.$n("cave")).width(childWidth+"px");
			this.childWidth = childWidth;
		}
	},
	onChildRemoved_: function (/*child*/) {
		if(this.desktop){
			var childWidth=0;
			jq(this.$n("cave")).children().each(
				function(){
					childWidth += jq(this).width();
			});
			jq(this.$n("cave")).width(childWidth+"px");
			this.childWidth = childWidth;
		}
	},
	redraw: function (out) {
		var uuid = this.uuid;
		out.push('<div', this.domAttrs_(), '>',
			'<div id="', uuid, '-right"></div>',
			'<div id="', uuid, '-left"></div>',
			'<div id="', uuid, '-body" class="', this.getZclass(), '-body">',
			'<div id="', uuid, '-cave">');
		for (var w = this.firstChild; w; w = w.nextSibling)
			w.redraw(out);
		out.push('<div class="z-clear"></div></div></div></div>');
	}

});
});

zk.load('zul.wgt', function () {
ngdir.Category = zk.$extends(zul.wgt.Button, {
	redraw: function (out) {
		var zcls = this.getZclass();
		out.push('<div', this.domAttrs_(), '>');
			out.push('<img id="', this.uuid, '-img"','src="',this.getImage() ,'" title="',this.getLabel(),'" class="', zcls,'-img"/>');
			
			out.push('<div id="',this.uuid, '-label" class="', zcls,'-text">');
			
			out.push(this.getLabel());
		out.push('</div></div>');
	},
	doMouseOver_: function (evt) {
		jq(this.$n()).addClass("ngdirweb-over");
	},
	doMouseOut_: function (evt) {
		if (zk.ie && jq.isAncestor(this.$n(), evt.domEvent.relatedTarget || evt.domEvent.toElement))
			return; //nothing to do
		jq(this.$n()).removeClass("ngdirweb-over");
	},
	doClick_: function (evt){
		this.$supers('doClick_', arguments);
		jq(this.$n()).addClass("ngdirweb-seld")
						  .siblings().removeClass("ngdirweb-seld");
	}
});
});
