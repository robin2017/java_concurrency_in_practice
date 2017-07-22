package util.common;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import static util.common.CollectionUtil.collection2str;

/**文件夹操作工具类
 * @author robin
 * @version 1.0
 * */
public final class DirectoryUtil {
    /**文件夹遍历函数
     * @parm start 文件夹
     * @return treeinfo
     * */
    public static TreeInfo traversal(File start) { // Everything
        return recurseDirs(start, ".*");
    }
    /**文件夹遍历函数
     * @parm start 文件夹名称
     * @return treeinfo
     * */
    public static TreeInfo traversal(String start) {
        return recurseDirs(new File(start), ".*");
    }
    /**文件夹遍历函数
     * @parm start 文件夹名称
     * @parm regex 正则表达式
     * @return treeinfo
     * */
    public static TreeInfo
    traversal(String start, String regex) { // Begin recursion
        return recurseDirs(new File(start), regex);
    }
    /**文件夹遍历函数
     * @parm start 文件夹
     * @parm regex 正则表达式
     * @return treeinfo
     * */
    public  static TreeInfo
    traversal(File start, String regex) { // Overloaded
        return recurseDirs(start, regex);
    }
    private static File[]
    local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            public boolean accept(File dir, String name) {
                return pattern.matcher(
                        new File(name).getName()).matches();
            }
        });
    }
    private static File[]
    local(String path, final String regex) { // Overloaded
        return local(new File(path), regex);
    }
    /**存储文件夹信息的内部类
     * */
    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();
        // The default iterable element is the file list:
        public Iterator<File> iterator() {
            return files.iterator();
        }
        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }
        //线形集合list==》string
        /**将文件夹信息以字符串形式显示
         * */
        public String toString() {
            return "dirs: " + collection2str(dirs) +
                    "\n\nfiles: " + collection2str(files);
        }
    }


    //树状目录==》线形集合list
    static TreeInfo recurseDirs(File startDir, String regex){
        TreeInfo result = new TreeInfo();
        for(File item : startDir.listFiles()) {
            if(item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else // Regular file
                if(item.getName().matches(regex))
                    result.files.add(item);
        }
        return result;
    }
    /**简单测试函数
     * @param args 文件夹路径
     * */
    public static void main(String[] args) {
        if(args.length == 0)
            System.out.println(traversal("."));
        else
            for(String arg : args)
                System.out.println(traversal(arg));
    }
}
