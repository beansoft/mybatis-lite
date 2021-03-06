package com.github.mustfun.mybatis.plugin.alias;

import com.github.mustfun.mybatis.plugin.util.JavaUtils;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.Set;

/**
 * @author yanglin
 * @updater itar
 * @function 别名解析抽象类
 */
public abstract class AliasResolver {

    protected Project project;

    public AliasResolver(Project project) {
        this.project = project;
    }

    /**
     * 新增别名描述
     * @param descs
     * @param clazz
     * @param alias
     * @return
     */
    @NotNull
    protected Optional<AliasDesc> addAliasDesc(@NotNull Set<AliasDesc> descs, @Nullable PsiClass clazz,
                                               @Nullable String alias) {
        if (null == alias || !JavaUtils.isModelClazz(clazz)) {
            return Optional.empty();
        }
        AliasDesc desc = new AliasDesc();
        descs.add(desc);
        desc.setClazz(clazz);
        desc.setAlias(alias);
        return Optional.of(desc);
    }

    /**
     * 获取别名描述
     * @param element
     * @return
     */
    @NotNull
    public abstract Set<AliasDesc> getClassAliasDescriptions(@Nullable PsiElement element);

    /**
     * 获取别名描述 - 根据名称
     * @param name
     * @return
     */
    @Nullable
    public  AliasDesc getClassAliasByName(String name){
        return null;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
