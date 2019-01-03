//package org.test.charttest;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//import com.vaadin.data.TreeData;
//import com.vaadin.data.ValueProvider;
//import com.vaadin.data.provider.TreeDataProvider;
//import com.vaadin.ui.HorizontalLayout;
//import com.vaadin.ui.Layout;
//import com.vaadin.ui.Tree;
//import com.vaadin.ui.VerticalLayout;
//
//public class VaadinTreeTest {
//	static int index=0;
//
//	public static Layout getTestLayout() {
//		HorizontalLayout horizontalLayout = new HorizontalLayout();
//		horizontalLayout.addStyleName("mylayout");
//		Tree<String> tree = new Tree<>("Hardware Inventory");
//		tree.setDataProvider(getDataprovider());
//		horizontalLayout.addComponent(tree);
//		return horizontalLayout;
//	}
//
//	public static TreeDataProvider<String> getDataprovider() {
//		TreeData<String> treeData = new TreeData<>();
//
//		List<String> rootItems = Arrays.asList("Parent1", "Parent2");
//		treeData.addItems(rootItems, (ValueProvider<String, Collection<String>>) s -> {
//			System.out.println(s);
//			if (s.equals("Parent1"))
//				return Arrays.asList("Child"+(++index),"Child"+(++index));
//			else
//				return Arrays.asList();
//		});
////		treeData.addItems(null, "Desktops", "Laptops", "Test")
////        .addItems("Desktops", "Dell GX240", "Dell GX260", "Dell GX280")
////        .addItems("Laptops", "IBM T40", "IBM T43", "IBM T60").addItem("Test", "");
//		TreeDataProvider<String> dp = new TreeDataProvider<>(treeData);
//		return dp;
//	}
//
//}
